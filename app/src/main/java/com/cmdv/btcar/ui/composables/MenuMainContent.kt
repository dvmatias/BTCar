package com.cmdv.btcar.ui.composables

import android.Manifest
import android.app.Activity
import android.content.pm.ActivityInfo
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.cmdv.btcar.askPermissions
import com.cmdv.btcar.askSinglePermission
import com.cmdv.btcar.domain.uievent.UiEvent
import com.cmdv.btcar.domain.uistate.MenuUIState
import com.cmdv.btcar.ui.BluetoothCarViewModel
import com.cmdv.common.Constants.TAG_LOG_D
import com.cmdv.common.Constants.requiredPermissionsInitialClient

@Composable
fun MenuMainContent(
    navHostController: NavHostController,
    uiState: MenuUIState,
    viewModel: BluetoothCarViewModel
) {
    val activity = LocalContext.current as Activity
    activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

    val locationPermissionLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                // Permission Accepted: Do something
                viewModel.handleUiEvent(UiEvent.Connect)
            } else {
                // Permission Denied: Do something
                Log.i(TAG_LOG_D, "Permission Denied")
                Toast.makeText(
                    activity,
                    "You must manually select the option 'Allow all the time' for location in order for this app to work!",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    /**
     * Requesting the Manifest.permission.ACCESS_BACKGROUND_LOCATION permission after
     * the Manifest.permission.ACCESS_COARSE_LOCATION has been granted
     *
     */
    fun extraLocationPermissionRequest() {
        askSinglePermission(
            locationPermissionLauncher,
            Manifest.permission.ACCESS_BACKGROUND_LOCATION,
            activity
        ) {
            viewModel.handleUiEvent(UiEvent.Connect)
        }
    }

    val multiplePermissionLauncher =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            rememberLauncherForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
                Log.i(TAG_LOG_D, "Launcher result: $permissions")
                if (permissions.containsValue(false)) {
                    Log.i(TAG_LOG_D, "At least one of the permissions was not granted.")
                    Toast.makeText(
                        activity,
                        "At least one of the permissions was not granted. Go to app settings and give permissions manually",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    //do something
                    viewModel.handleUiEvent(UiEvent.Connect)
                }
            }
        } else {
            rememberLauncherForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
                Log.i(TAG_LOG_D, "Launcher result: $permissions")
                if (permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false)) {
                    //permission for location was granted.
                    //we direct the user to select "Allow all the time option"
                    Toast.makeText(
                        activity,
                        "You must select the option 'Allow all the time' for the app to work",
                        Toast.LENGTH_SHORT
                    ).show()
                    extraLocationPermissionRequest()
                } else {
                    Toast.makeText(
                        activity,
                        "Location permission was not granted. Please do so manually",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    if (uiState.isLoading) {
        CircularProgressIndicator(color = Color(0xFFFF0000L))
    } else {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {
                    askPermissions(
                        multiplePermissionLauncher,
                        requiredPermissionsInitialClient,
                        activity
                    ) { viewModel.handleUiEvent(UiEvent.Connect) }

                }) {
                    Text(text = "Connect")
                }
            }
        }
    }
}
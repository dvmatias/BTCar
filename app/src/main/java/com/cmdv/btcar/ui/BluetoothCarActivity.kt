package com.cmdv.btcar.ui

import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cmdv.btcar.domain.uievent.UiEvent
import com.cmdv.btcar.navigation.NavDestination
import com.cmdv.btcar.ui.theme.BTCarTheme
import com.cmdv.btcar.ui.composables.ConnectionMainContent
import com.cmdv.btcar.domain.uistate.MenuUIState
import com.cmdv.btcar.ui.composables.MenuMainContent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BluetoothCarActivity : ComponentActivity() {

    private val viewModel: BluetoothCarViewModel by viewModels()

    private val enableBluetoothResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            Toast.makeText(this, "Bluetooth Enabled!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(
                this,
                "Bluetooth is required for this app to run",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navHostController = rememberNavController()
            BTCarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(
                        navController = navHostController,
                        startDestination = NavDestination.DEST_MENU
                    ) {
                        composable(NavDestination.DEST_MENU) {
                            MenuMainContent(
                                navHostController,
                                MenuUIState(),
                                viewModel
                            )
                        }
                        composable(NavDestination.DEST_CONNECTION) {
                            ConnectionMainContent(navHostController)
                        }
                    }
                }
            }
        }

        lifecycleScope.launch {
            viewModel.uiEvent.collect {
                handleUiEvent(it)
            }
        }
    }

    private fun handleUiEvent(uiEvent: UiEvent) {
        when(uiEvent) {
            UiEvent.Connect -> viewModel.startConnectionProcess()
            UiEvent.AskUserEnableBluetooth -> enableBluetooth()
        }
    }

    private fun enableBluetooth() {
        val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
        enableBluetoothResultLauncher.launch(enableBtIntent)
    }
}
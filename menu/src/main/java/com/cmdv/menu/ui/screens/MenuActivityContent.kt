package com.cmdv.menu.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cmdv.domain.uievent.menu.MenuUIEvent
import com.cmdv.domain.uistate.menu.MenuUIState
import com.cmdv.menu.ui.MenuActivityViewModel
import com.cmdv.menu.ui.theme.BTCarTheme

@Composable
fun MenuActivityContent(
    uiState: MenuUIState,
    viewModel: MenuActivityViewModel
) {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { viewModel.onEvent(MenuUIEvent.Connect) }) {
                Text(text = "Connect")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = { viewModel.onEvent(MenuUIEvent.Start) }) {
                Text(text = "Start")
            }
        }

        if (uiState.isLoading) {
            CircularProgressIndicator(color = Color(0xFFFF0000L))
        }
    }
}

// TODO
//@Preview(showBackground = true, backgroundColor = 0xFFFFFFL, showSystemUi = true)
//@Composable
//fun PreviewMenuActivityContent() {
//    BTCarTheme {
//        MenuActivityContent(
//            MenuUIState(
//                isControllerBluetoothModulePresent = true,
//                isControllerBluetoothModuleOn = true,
//                isControllerConnectedToCar = false,
//                isLoading = false
//            ), MenuActivityViewModel()
//        )
//    }
//}
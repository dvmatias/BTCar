package com.cmdv.menu

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.cmdv.common.navigator.Navigator
import com.cmdv.domain.uievent.menu.MenuUIEvent
import com.cmdv.menu.ui.MenuActivityViewModel
import com.cmdv.menu.ui.screens.MenuActivityContent
import com.cmdv.menu.ui.theme.BTCarTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MenuActivity : ComponentActivity() {
    private val viewModel: MenuActivityViewModel by viewModels()

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.lifecycleScope.launch {
            viewModel.event
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect { event ->
                    handleUiEvent(event)
                }
        }

        setContent {
            BTCarTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val uiState by viewModel.uiState.collectAsState()
                    MenuActivityContent(uiState, viewModel)
                }
            }
        }
    }

    private fun handleUiEvent(event: MenuUIEvent) {
        when (event) {
            MenuUIEvent.Connect -> navigator.toConnectivity(
                this@MenuActivity,
                null,
                false
            )

            else -> Toast.makeText(
                this@MenuActivity,
                "Event not handled",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
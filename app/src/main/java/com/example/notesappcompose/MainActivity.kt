package com.example.notesappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import com.example.notesappcompose.routing.AppRouter
import com.example.notesappcompose.routing.Screen
import com.example.notesappcompose.ui.screens.NotesScreen
import com.example.notesappcompose.ui.screens.SaveNoteScreen
import com.example.notesappcompose.ui.screens.TrashScreen
import com.example.notesappcompose.ui.theme.NotesAppComposeTheme
import com.example.notesappcompose.viewmodel.MainViewModel
import com.example.notesappcompose.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels(factoryProducer = {
        MainViewModelFactory(
            this,
            (application as NotesApplication).dependencyInjector.repository
        )
    })

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAppComposeTheme {
                MainActivityScreen(viewModel = viewModel)
            }
        }
    }

    @Composable
    @ExperimentalMaterialApi
    private fun MainActivityScreen(viewModel: MainViewModel){
        Surface {
            when (AppRouter.currentScreen) {
                is Screen.Notes -> NotesScreen(viewModel = viewModel)
                is Screen.SaveNote -> SaveNoteScreen(viewModel = viewModel)
                is Screen.Trash -> TrashScreen(viewModel = viewModel)
            }
        }
    }
}

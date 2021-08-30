package com.example.notesappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.notesappcompose.ui.screens.NotesScreen
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAppComposeTheme {
                NotesScreen(viewModel = viewModel)
            }
        }
    }
}

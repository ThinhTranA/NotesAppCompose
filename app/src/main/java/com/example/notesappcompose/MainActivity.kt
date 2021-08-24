package com.example.notesappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import com.example.notesappcompose.routing.Screen
import com.example.notesappcompose.ui.components.AppDrawer
import com.example.notesappcompose.ui.components.Note
import com.example.notesappcompose.ui.theme.NotesAppComposeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAppComposeTheme {
                val coroutineScope = rememberCoroutineScope()
                val scaffoldState: ScaffoldState = rememberScaffoldState()

                Scaffold(
                    scaffoldState = scaffoldState,
                    drawerContent = {
                        AppDrawer(
                            currentScreen = Screen.Notes,
                            closeDrawerAction = {
                                coroutineScope.launch {
                                    scaffoldState.drawerState.close()
                                }
                            }
                        )
                    },
                    content = {
                        Note()
                    }
                )
            }
        }
    }
}

package com.example.notesappcompose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import com.example.notesappcompose.domain.model.NoteModel
import com.example.notesappcompose.routing.Screen
import com.example.notesappcompose.ui.components.AppDrawer
import com.example.notesappcompose.ui.components.Note
import com.example.notesappcompose.ui.components.TopAppBar
import com.example.notesappcompose.viewmodel.MainViewModel
import kotlinx.coroutines.launch

@Composable
fun NotesScreen(viewModel: MainViewModel) {

    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    val notes: List<NoteModel> by viewModel
        .notesNotInTrash
        .observeAsState(listOf())
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "JetNotes",
                        color = MaterialTheme.colors.onPrimary
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        coroutineScope.launch { scaffoldState.drawerState.open() }
                    }) {
                        Icon(
                            imageVector = Icons.Filled.List,
                            contentDescription = "Drawer Button"
                        )
                    }
                }
            )
        },
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
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.onCreateNewNoteClick() },
                contentColor = MaterialTheme.colors.background,
                content = {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Add Note Button"
                    )
                }
            )
        },
        content = {
            if(notes.isNotEmpty()) {
                NotesList(
                    notes = notes,
                    onNoteCheckedChange = {
                                          viewModel.onNoteCheckedChange(it)
                    },
                    onNoteClick = {viewModel.onNoteClick(it)})
            }
        }
    )
}

@Composable
private fun NotesList(
    notes: List<NoteModel>,
    onNoteCheckedChange: (NoteModel) -> Unit,
    onNoteClick: (NoteModel) -> Unit
) {
    LazyColumn {
        items (count = notes.size) { noteIndex ->
            val note = notes[noteIndex]
            Note(
                note = note,
                onNoteClick = onNoteClick,
                onNoteCheckedChange = onNoteCheckedChange
            )
        }
    }
}

@Preview
@Composable
private fun NotesListPreview() {
    NotesList(notes = listOf(
        NoteModel(1, "Note 1", "Content 1", null),
        NoteModel(1, "Note 2", "Content 2", false),
        NoteModel(1, "Note 3", "Content 3", true),
    ), onNoteCheckedChange = {},
        onNoteClick = {}
    )
}

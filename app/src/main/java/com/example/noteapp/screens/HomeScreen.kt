package com.example.noteapp.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteapp.R
import com.example.noteapp.components.CustomButton
import com.example.noteapp.components.CustomTextField
import com.example.noteapp.data.NotesDataSource
import com.example.noteapp.models.NoteModel
import com.example.noteapp.widgets.NoteCardWidget

@Composable
fun HomeScreen(
    notes: List<NoteModel>,
    addNote: (NoteModel) -> Unit,
    removeNote: (NoteModel) -> Unit,
) {
    var titleController by remember {
        mutableStateOf("")
    }

    var descriptionController by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = stringResource(id = R.string.app_name))

        }, actions = {
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "Notification Icon"
            )
        }, backgroundColor = Color.LightGray
        )
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextField(
                modifier = Modifier.fillMaxWidth(),
                text = titleController, label = "Title",
                onTextChange = {
                    if (it.all { char -> char.isLetter() || char.isWhitespace() }) {
                        titleController = it
                    }
                },

                )
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextField(
                modifier = Modifier.fillMaxWidth(),
                text = descriptionController, label = "Add a note", onTextChange = {
                    if (it.all { char -> char.isLetter() || char.isWhitespace() }) {
                        descriptionController = it
                    }
                })

            Spacer(modifier = Modifier.height(20.dp))

            CustomButton(title = "Save", onclick = {
                if (titleController.isNotEmpty() && descriptionController.isNotEmpty()) {
                    addNote(NoteModel(title = titleController, description = descriptionController))
                    titleController = ""
                    descriptionController = ""
                    Toast.makeText(context, "Note added successfully", Toast.LENGTH_LONG).show()
                }
            }, textStyle = MaterialTheme.typography.h5.copy(color = Color.White))
            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn {
                items(notes) { note ->
                    NoteCardWidget(note = note, onclick = { removeNote(note) })
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(notes = NotesDataSource().loadNotes(), addNote = {}, removeNote = {})
}
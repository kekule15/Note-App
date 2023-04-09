package com.example.noteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.noteapp.screens.HomeScreen
import com.example.noteapp.ui.theme.NoteAppTheme
import com.example.noteapp.viewmodels.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val noteViewModel: NoteViewModel by viewModels()
                    HomeScreen(notes = noteViewModel.noteList.collectAsState().value, addNote = {
                        noteViewModel.addNote(it)
                    }, removeNote = {
                        noteViewModel.removeNote(it)
                    })
                }
            }
        }
    }
}



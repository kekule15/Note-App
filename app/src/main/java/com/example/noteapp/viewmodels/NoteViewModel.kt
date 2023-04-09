package com.example.noteapp.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.data.NotesDataSource
import com.example.noteapp.models.NoteModel
import com.example.noteapp.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {
    private val _noteList = MutableStateFlow<List<NoteModel>>(emptyList())

    public val noteList = _noteList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged().collect { listOfNotes ->
                if (listOfNotes.isNullOrEmpty()) {
                    Log.d("Empty", "Empty List")
                } else {
                    _noteList.value = listOfNotes
                }
            }
        }
    }

     fun addNote(note: NoteModel) = viewModelScope.launch { repository.addNote(note) }
     fun updateNote(note: NoteModel) = viewModelScope.launch { repository.updateNote(note) }
     fun removeNote(note: NoteModel) =
        viewModelScope.launch { repository.deleteOneNote(note) }

}


package com.example.noteapp.data

import com.example.noteapp.models.NoteModel

class NotesDataSource {
    fun loadNotes(): List<NoteModel> {
        return listOf(

            NoteModel(title = "A good day", description = "We went on a vacation by the lake"),
            NoteModel(
                title = "Android Compose",
                description = "Working on Android Compose course today"
            ),
            NoteModel(title = "Keep at it...", description = "Sometimes things just happen"),
            NoteModel(title = "A movie day", description = "Watching a movie with family today"),
            NoteModel(title = "A movie day", description = "Watching a movie with family today"),
            NoteModel(title = "A movie day", description = "Watching a movie with family today"),
            NoteModel(title = "A movie day", description = "Watching a movie with family today"),
            NoteModel(title = "A movie day", description = "Watching a movie with family today"),
            NoteModel(title = "A movie day", description = "Watching a movie with family today"),
            NoteModel(title = "A movie day", description = "Watching a movie with family")

        )
    }
}
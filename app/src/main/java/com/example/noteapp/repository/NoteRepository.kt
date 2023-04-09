package com.example.noteapp.repository

import com.example.noteapp.data.NoteDatabaseDao
import com.example.noteapp.models.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject  constructor(private val noteDatabaseDao: NoteDatabaseDao) {

    suspend fun addNote(noteModel: NoteModel) = noteDatabaseDao.addNote(noteModel)
    suspend fun updateNote(noteModel: NoteModel) = noteDatabaseDao.updateNote(noteModel)
    suspend fun deleteOneNote(noteModel: NoteModel) = noteDatabaseDao.deleteOneNote(noteModel)
    suspend fun deleteAllNotes() = noteDatabaseDao.deleteAllNotes()
    fun getAllNotes(): Flow<List<NoteModel>> = noteDatabaseDao.getAllNotes().flowOn(Dispatchers.IO).conflate()
    suspend fun getOneNote(noteModel: NoteModel) = noteDatabaseDao.getNoteById(noteModel.id.toString())
}
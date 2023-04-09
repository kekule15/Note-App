package com.example.noteapp.data


import androidx.room.*
import com.example.noteapp.models.NoteModel
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDatabaseDao {
    @Query("SELECT * FROM notes_tbl")
    fun getAllNotes(): Flow<List<NoteModel>>

    @Query("SELECT * FROM notes_tbl WHERE id =:id")
    suspend fun getNoteById(id: String): NoteModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note: NoteModel)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(note: NoteModel)

    @Query("DELETE FROM notes_tbl")
    suspend fun deleteAllNotes()

    @Delete
    suspend fun deleteOneNote(note: NoteModel)
}

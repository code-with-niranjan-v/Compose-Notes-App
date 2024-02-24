package com.example.todocompose.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.todocompose.data.NotesData

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(notesData: NotesData)

    @Query("select * from notes_tableDb")
    fun getAllNotes():LiveData<List<NotesData>>

    @Delete
    fun delete(notesData: NotesData)

}
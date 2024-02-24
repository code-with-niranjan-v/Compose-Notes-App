package com.example.todocompose.repository

import com.example.todocompose.data.NotesData
import com.example.todocompose.db.NotesDatabase
import javax.inject.Inject

class NotesRepository @Inject constructor(
    private val db:NotesDatabase
){

    fun insertNote(notesData: NotesData) = db.getDao().insertNotes(notesData)

    fun getAllNotes() = db.getDao().getAllNotes()

    fun delete(notesData: NotesData) = db.getDao().delete(notesData)


}
package com.example.todocompose.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_tableDb")
data class NotesData(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val title:String,
    val description:String
)

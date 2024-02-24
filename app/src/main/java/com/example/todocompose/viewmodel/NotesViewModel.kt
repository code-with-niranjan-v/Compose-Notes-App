package com.example.todocompose.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todocompose.data.NotesData
import com.example.todocompose.repository.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val repo:NotesRepository
):ViewModel() {


    val _listOfNotes: LiveData<List<NotesData>>
        get() = repo.getAllNotes()




    fun insertNote(notesData: NotesData){
        CoroutineScope(Dispatchers.IO).launch {
            repo.insertNote(notesData)
        }
    }

    fun delete(notesData: NotesData){
        CoroutineScope(Dispatchers.IO).launch{
            repo.delete(notesData)
        }
    }

}
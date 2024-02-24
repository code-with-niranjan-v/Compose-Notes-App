package com.example.todocompose.navigation

sealed class Screen(val route:String) {
    object NotesScreen:Screen(route = "NotesScreen")
    object AddNotesScreen:Screen(route = "AddNotesScreen/{title}/{description}/{id}"){
        fun passData(title:String?=null,description:String?=null,id:String?=null):String{
            return "AddNotesScreen/$title/$description/$id"
        }
    }

}
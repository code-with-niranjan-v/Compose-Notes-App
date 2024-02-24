package com.example.todocompose.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.LiveData
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todocompose.data.NotesData
import com.example.todocompose.ui.screens.NotesAddScreen
import com.example.todocompose.ui.screens.NotesScreen
import com.example.todocompose.viewmodel.NotesViewModel

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    viewModel: NotesViewModel
){
    NavHost(startDestination = Screen.NotesScreen.route, navController = navController){
        composable(Screen.NotesScreen.route){
            NotesScreen(navController = navController,viewModel)
        }
        composable(Screen.AddNotesScreen.route,
            arguments = listOf(navArgument("title"){
                type = NavType.StringType
            },navArgument("description"){
                type = NavType.StringType
            },navArgument("id"){
                type = NavType.IntType
            },
                ),
        ){

            NotesAddScreen(navController = navController,viewModel,titleData =it.arguments?.getString("title"), descriptionData = it.arguments?.getString("description"),idData = it.arguments?.getInt("id") )
        }
    }
}
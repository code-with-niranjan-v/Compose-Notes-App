package com.example.todocompose.ui.screens

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.todocompose.data.NotesData
import com.example.todocompose.navigation.SetupNavGraph
import com.example.todocompose.ui.theme.TodoComposeTheme
import com.example.todocompose.viewmodel.NotesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel:NotesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoComposeTheme {
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//
//                }
                val navController = rememberNavController()
                val onClickSave = {title:String,description:String -> viewModel.insertNote(
                    NotesData(
                        title=title,
                        description=description
                    )
                )}
                SetupNavGraph(navController = navController,viewModel)

                }
            }
        }
    }







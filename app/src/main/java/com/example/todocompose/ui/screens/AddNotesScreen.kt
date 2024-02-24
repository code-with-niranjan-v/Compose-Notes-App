package com.example.todocompose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todocompose.data.NotesData
import com.example.todocompose.viewmodel.NotesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesAddScreen(
    navController: NavController,
    viewModel: NotesViewModel,
    titleData:String?=null,
    descriptionData:String?=null,
    idData:Int?=null,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        var title by remember {
            mutableStateOf(titleData?:"")
        }
        var description by remember {
            mutableStateOf(descriptionData?:"")
        }

        TextField(value = title ,
            onValueChange = {title  = it},
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            label = {
                    Text(text = "Title", fontSize = 12.sp)
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            )
            )

        TextField(value = description ,
            onValueChange = {description  = it},
            modifier = Modifier
                .fillMaxWidth()
                .weight(8f),
            label = {
                Text(text = "Description", fontSize = 12.sp)
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            )
        )

        TextButton(

            onClick = {
                val id = idData ?: 0
                viewModel.insertNote(NotesData(id = id,title = title, description = description)) },
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Text(
                text = "Save",
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth())
        }
    }
}
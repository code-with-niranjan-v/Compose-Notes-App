package com.example.todocompose.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.todocompose.R
import com.example.todocompose.data.NotesData
import com.example.todocompose.navigation.Screen
import com.example.todocompose.viewmodel.NotesViewModel


@Composable
fun NotesScreen(navController: NavController,viewModel: NotesViewModel
) {
    val listOfNotesData = viewModel._listOfNotes.observeAsState()
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn{
            items(listOfNotesData.value?.size?:0){
                NotesItems(notesData = listOfNotesData.value?.get(it) ?: NotesData(title="test",description= "test"),navController,viewModel)
            }
        }
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End) {
            FloatingActionButton(
                onClick = {navController.navigate(Screen.AddNotesScreen.passData(" "," ","0")) },
                modifier = Modifier.padding(12.dp),

                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_add_24),
                        contentDescription ="Add a Note" )
            }
        }
    }
}

@Composable
fun NotesItems(
    notesData: NotesData,
    navController: NavController,
    viewModel: NotesViewModel,
) {
    Card(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate(
                    Screen.AddNotesScreen.passData(
                        notesData.title,
                        notesData.description,
                        notesData.id.toString()
                    )
                )
            }
    ) {
        var isExpanded by remember {
            mutableStateOf(false)
        }

            Column(modifier = Modifier
                .animateContentSize(tween(durationMillis = 300, easing = LinearOutSlowInEasing))){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = notesData.title,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(12.dp),
                        overflow = TextOverflow.Ellipsis
                    )

                    Row {
                        IconButton(onClick = { viewModel.delete(notesData) }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_delete_24),
                                contentDescription = "Delete"
                            )
                        }
                        IconButton(onClick = { isExpanded = !isExpanded }) {
                            Icon(
                                painter = painterResource(id = if (isExpanded) R.drawable.baseline_expand_less_24 else R.drawable.baseline_expand_more_24),
                                contentDescription = if (isExpanded) "Collapse" else "Expand"
                            )
                        }
                    }


                }
                if(isExpanded){
                    Text(
                        text = notesData.description,
                        modifier = Modifier
                            .padding(12.dp),
                        fontSize = 18.sp,
                        maxLines = 5
                    )
                }
            }


    }
}

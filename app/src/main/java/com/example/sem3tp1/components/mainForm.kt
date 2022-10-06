package com.example.sem3tp1.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sem3tp1.Task

@Composable
fun Form() {
    Scaffold {
        Column {
            TopAppBar {
                Text(text = "Todo App", modifier = Modifier.padding(16.dp))
            }
            Text(text = "Add a new task", modifier = Modifier.padding(all = 10.dp)
                .fillMaxWidth(), style = MaterialTheme.typography.h2)
            val itemList = remember {
                mutableStateListOf(Task(1, "Task 1", false))
            }
            Row( modifier = Modifier.padding(all = 10.dp)) {
                var newItem by remember { mutableStateOf("") }
                var allTasks by remember { mutableStateOf(1) }
                TextField(
                    value = newItem,
                    onValueChange ={newItem=it},
                    placeholder = { Text("Enter a new item") },
                    label={ Text("CheckList") },
                    modifier = Modifier.padding(all = 10.dp)
                )
                Button(
                    onClick = {
                        if (newItem != "") {
                            itemList.add(Task(allTasks+1, newItem, true))
                            allTasks++
                            newItem = ""
                        }
                    },
                    // Uses ButtonDefaults.ContentPadding by default
                    contentPadding = PaddingValues(
                        start = 20.dp,
                        top = 12.dp,
                        end = 20.dp,
                        bottom = 12.dp
                    ),
                    modifier = Modifier
                        .padding(all = 14.dp)
                        .fillMaxWidth()
                ) {
                    // Inner content including an icon and a text label
                    Icon(
                        Icons.Rounded.Add,
                        contentDescription = "Account",
                        modifier = Modifier.size(ButtonDefaults.IconSize)
                    )
                }
            }
            ShowItems(itemList = itemList)
        }
    }
}
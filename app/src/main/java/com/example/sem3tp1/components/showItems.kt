package com.example.sem3tp1.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.sem3tp1.Task

@Preview(showBackground = true)
@Composable
fun ShowItems(itemList: MutableList<Task> = mutableListOf()) {
    LazyColumn() {
        items(itemList.size) { index ->
            showItem(itemList[index],itemList)
        }
    }
}
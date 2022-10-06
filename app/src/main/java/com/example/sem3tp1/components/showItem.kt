package com.example.sem3tp1.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sem3tp1.Task

@Composable
fun showItem(item: Task, itemList: MutableList<Task> = mutableListOf()){
    Row(modifier = Modifier.fillMaxWidth()
        .padding(all = 10.dp),verticalAlignment = Alignment.CenterVertically) {
        Text("id: ${item.id}" , modifier = Modifier.padding(all = 10.dp),
            style = TextStyle(
                fontSize = 26.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.W800,
            )
        )
        Text(item.title, modifier = Modifier.padding(all = 10.dp),
            style = TextStyle(
                fontSize = 26.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.W800,
            )
        )
        //checklist
        Checkbox(
            checked = item.checked,
            onCheckedChange = { OnCheck(item,itemList) },
            modifier = Modifier.padding(all = 10.dp)
        )
        Button(
            onClick = { removeTask(item,itemList) },
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            ),
            modifier = Modifier
                .padding(all = 10.dp)
        ) {
            Icon(
                Icons.Rounded.Close,
                contentDescription = "Remove",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
        }
    }
}

fun removeTask(item: Task, itemList: MutableList<Task>) {
    itemList.remove(item)
}

fun OnCheck(item: Task, itemList: MutableList<Task>) {
    item.checked = !item.checked
    itemList.remove(item)
    itemList.add(item)
}
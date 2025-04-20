package com.example.todoappwithjetpack.ui.screens.list

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.todoappwithjetpack.R

@Composable
fun ListScreen(navigateToTaskScreen: (taskId:Int) -> Unit) {
    Scaffold(
        topBar = {
            listAppBar()
        },
        floatingActionButton = {
            ListFab(navigateToTaskScreen)
        },
        content = { }
    )
}


@Composable
fun ListFab(
    navigateToTaskScreen: (taskId:Int) -> Unit
) {
    FloatingActionButton(
        onClick = {
            navigateToTaskScreen(-1)
        },
        containerColor = Color.Black,
        shape = CircleShape
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(R.string.add),
            tint = Color.White
        )

    }
}

@Preview
@Composable
fun ListScreenPreview() {
    ListScreen(navigateToTaskScreen = {})
}
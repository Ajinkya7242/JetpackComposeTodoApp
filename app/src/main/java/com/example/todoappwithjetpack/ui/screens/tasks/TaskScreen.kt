package com.example.todoappwithjetpack.ui.screens.tasks

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.todoappwithjetpack.model.ToDoModel
import com.example.todoappwithjetpack.utility.Action


@Composable
fun TaskScreen(
    selectedTask:ToDoModel?,
    navigateToScreen: (Action) -> Unit,
) {

    Scaffold(
        topBar = {
            TaskAppBar(selectedTask=selectedTask,navigateToScreen=navigateToScreen)

        },
        content = {
        }
    )
}
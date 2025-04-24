package com.example.todoappwithjetpack.ui.screens.tasks

import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.todoappwithjetpack.model.Priority
import com.example.todoappwithjetpack.model.ToDoModel
import com.example.todoappwithjetpack.utility.Action


@Composable
fun TaskAppBar(
    selectedTask:ToDoModel?,
    navigateToScreen: (Action) -> Unit,
) {
    if(selectedTask==null){
        NewTaskAppBar(navigateToScreen)
    }else{
        ExsitingTaskAppBar(selectedTask,navigateToScreen)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTaskAppBar(
    navigateToScreen: (Action) -> Unit,
) {
    TopAppBar(
        navigationIcon = {
            backAction(onBackClicked = {
                navigateToScreen
            })
        },
        title = {
            Text(
                text = "Add Tasks",
                color = Color.White
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        actions = {
            AddAction(onAddClicked = navigateToScreen)
        }
    )
}

@Composable
fun backAction(
    onBackClicked: (Action) -> Unit
) {

    IconButton(onClick = {
        onBackClicked(Action.NO_ACTION)
    }) {
        Icon(Icons.Default.ArrowBack, contentDescription = "back arrow", tint = Color.White)
    }

}

@Composable
fun AddAction(
    onAddClicked: (Action) -> Unit
) {

    IconButton(onClick = {
        onAddClicked(Action.ADD)
    }) {
        Icon(Icons.Default.Check, contentDescription = "ADD Task", tint = Color.White)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExsitingTaskAppBar(
    selectedTask: ToDoModel,
    navigateToScreen: (Action) -> Unit,
) {
    TopAppBar(
        navigationIcon = {
            CloseAction(onCloseClicked = navigateToScreen)
        },
        title = {
            Text(
                text = selectedTask.title,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        actions = {
            DeleteAction(onDeleteAction = navigateToScreen)
            UpdateAction(onUpdateClicked = navigateToScreen)
        }
    )
}

@Composable
fun CloseAction(
    onCloseClicked: (Action) -> Unit
) {

    IconButton(onClick = {
        onCloseClicked(Action.NO_ACTION)
    }) {
        Icon(Icons.Default.Close, contentDescription = "Close Task", tint = Color.White)
    }

}

@Composable
fun UpdateAction(
    onUpdateClicked: (Action) -> Unit
) {

    IconButton(onClick = {
        onUpdateClicked(Action.UPDATE)
    }) {
        Icon(Icons.Default.Edit, contentDescription = "Edit Task", tint = Color.White)
    }

}

@Composable
fun DeleteAction(
    onDeleteAction: (Action) -> Unit
) {

    IconButton(onClick = {
        onDeleteAction(Action.DELETE)
    }) {
        Icon(Icons.Default.Delete, contentDescription = "Delete Task", tint = Color.White)
    }

}

@Composable
@Preview
fun previewFun() {
    NewTaskAppBar(navigateToScreen = {})
}

@Composable
@Preview
fun previewFunExt() {
    ExsitingTaskAppBar(ToDoModel(0,"TItle","",Priority.HIGH),navigateToScreen = {})
}

package com.example.todoappwithjetpack.ui.screens.list

import android.util.Log
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todoappwithjetpack.R
import com.example.todoappwithjetpack.utility.SearchAppbarState
import com.example.todoappwithjetpack.viewmodels.SharedViewModel

@Composable
fun ListScreen(navigateToTaskScreen: (taskId:Int) -> Unit,viewModel:SharedViewModel) {

    LaunchedEffect(true) {
        Log.d("ListScreen","Launched effect triggered.")
        viewModel.getAllTasks()
    }
    val searchAppBarState:SearchAppbarState by viewModel._searchAppBarState
    val searchTextState:String by viewModel.serchTextState
    val allTasks by viewModel.allTasks.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize().padding(WindowInsets.systemBars.asPaddingValues()),
        topBar = {
            listAppBar(viewModel,searchAppBarState,searchTextState)
        },
        floatingActionButton = {
            ListFab(navigateToTaskScreen)
        },
        content = {paddingValues ->
            ListContent(
                toDoTasks = allTasks,
                navigateToTaskScreen = navigateToTaskScreen,
                modifier = Modifier.padding(paddingValues)
            )
        }
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
    ListScreen(navigateToTaskScreen = {}, viewModel = viewModel())
}
package com.example.todoappwithjetpack.navigation.destinations

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.internal.composableLambda
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todoappwithjetpack.ui.screens.tasks.TaskScreen
import com.example.todoappwithjetpack.utility.Action
import com.example.todoappwithjetpack.utility.AppConstants.TASK_ARGUMENT_KEY
import com.example.todoappwithjetpack.utility.AppConstants.TASK_SCREEN
import com.example.todoappwithjetpack.viewmodels.SharedViewModel

fun NavGraphBuilder.taskComposable(
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {

    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        sharedViewModel.getSelectedTasks(taskId)
        val selectedTask by sharedViewModel.selectedTask.collectAsState()
        TaskScreen(navigateToScreen = navigateToListScreen, selectedTask = selectedTask)
    }
}
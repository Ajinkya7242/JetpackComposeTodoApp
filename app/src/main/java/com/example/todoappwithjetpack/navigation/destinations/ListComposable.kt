package com.example.todoappwithjetpack.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todoappwithjetpack.ui.screens.list.ListScreen
import com.example.todoappwithjetpack.utility.AppConstants.LIST_ARGUMENT_KEY
import com.example.todoappwithjetpack.utility.AppConstants.LIST_SCREEN
import com.example.todoappwithjetpack.utility.AppConstants.TASK_ARGUMENT_KEY

fun NavGraphBuilder.listComposables(
    navigateToTaskScreen: (taskId:Int) -> Unit
) {
    composable(
        LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type=NavType.StringType
            defaultValue = "NO_ACTION"
        })
    ){
        ListScreen(navigateToTaskScreen = navigateToTaskScreen)
    }
}
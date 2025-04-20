package com.example.todoappwithjetpack.navigation.destinations

import androidx.compose.runtime.internal.composableLambda
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todoappwithjetpack.utility.Action
import com.example.todoappwithjetpack.utility.AppConstants.TASK_ARGUMENT_KEY
import com.example.todoappwithjetpack.utility.AppConstants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(navigateToListScreen:(Action)->Unit){

    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY){
            type=NavType.IntType
        })
    ){

    }
}
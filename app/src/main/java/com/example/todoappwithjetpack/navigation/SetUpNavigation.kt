package com.example.todoappwithjetpack.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.todoappwithjetpack.navigation.destinations.listComposables
import com.example.todoappwithjetpack.navigation.destinations.taskComposable
import com.example.todoappwithjetpack.utility.AppConstants.LIST_SCREEN

@Composable
fun setUpNavigation(
    navcontroller:NavHostController
){
    val screen=remember(navcontroller){
        Screens(navcontroller)
    }

    NavHost(navcontroller,startDestination = LIST_SCREEN,
    ){
        listComposables(
            navigateToTaskScreen = screen.task
        )
        taskComposable(
            navigateToListScreen = screen.list
        )
    }
}
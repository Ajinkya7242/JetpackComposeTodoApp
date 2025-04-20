package com.example.todoappwithjetpack.navigation

import androidx.navigation.NavHostController
import com.example.todoappwithjetpack.utility.Action
import com.example.todoappwithjetpack.utility.AppConstants.LIST_SCREEN

class Screens(navController:NavHostController) {

    val list:(Action)->Unit={action->
        navController.navigate("list/${action.name}"){
            popUpTo(LIST_SCREEN){inclusive=true}
        }
    }

    val task:(Int)->Unit={taskd->
        navController.navigate("task/${taskd}")
    }
}
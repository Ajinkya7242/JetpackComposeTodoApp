package com.example.todoappwithjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.todoappwithjetpack.navigation.setUpNavigation
import com.example.todoappwithjetpack.ui.theme.ToDoAppWithJetpackTheme
import com.example.todoappwithjetpack.viewmodels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
     private val viewModel: SharedViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        setContent {
            ToDoAppWithJetpackTheme {
//                SetStatusBarColor(color = MaterialTheme.colorScheme.primary)
                navController=rememberNavController()
                setUpNavigation(navController,viewModel)

            }
        }
    }

}


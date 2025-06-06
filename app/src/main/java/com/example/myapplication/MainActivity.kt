package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.view.GreetingScreen
import com.example.myapplication.view.ManagePlants
import com.example.myapplication.view.WaterPlants
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.viewmodel.PlantViewModel
import androidx.compose.runtime.remember



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()
                val plantViewModel = remember { PlantViewModel() }

                NavHost(navController = navController, startDestination = "GreetingScreen") {
                    composable("GreetingScreen") {
                        GreetingScreen(
                            onNavigate = { route -> navController.navigate(route) }
                        )
                    }
                    composable("ManagePlants") {
                        ManagePlants(
                            onBack = { navController.popBackStack() },
                            viewModel = plantViewModel
                        )
                    }
                    composable("WaterPlants") {
                        WaterPlants(
                            onBack = { navController.popBackStack() },
                            viewModel = plantViewModel
                        )
                    }
                }
            }
        }

    }
}

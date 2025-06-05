package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "greeting") {
                    composable("greeting"){
                        GreetingScreen(
                            onNavigate = {navController.navigate("second")}
                        )
                    }
                    composable("second"){
                        SecondScreen(
                            onBack = {navController.popBackStack()}
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingScreen(onNavigate: () -> Unit){
    Surface(
        color = Color.Green,
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ){
            Text("Hi, Welcome To Flowery!")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onNavigate) {
                Text("Go to Second Screen")
            }
        }

    }
}

@Composable
fun SecondScreen(onBack: () -> Unit) {
    Surface(
        color = Color.Cyan,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text("Wanna add some flowers? Cant do that yet...!")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onBack) {
                Text("Go back")
            }
        }
    }
}


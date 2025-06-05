package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        color = Color(174, 200, 164),
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ){
            Text(
                "Hi, Welcome To Flowery!",
                color = Color(59, 59, 26),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onNavigate,
                colors =  ButtonDefaults.buttonColors(Color(59, 59, 26))) {
                Text("Go to Second Screen")
            }
        }

    }
}

@Composable
fun SecondScreen(onBack: () -> Unit) {
    Surface(
        color = Color(231, 239, 199),
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text("Wanna add some flowers? Cant yet!",
                color = Color(59, 59, 26),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onBack,
                colors =  ButtonDefaults.buttonColors(Color(59, 59, 26))) {
                Text("Go back")
            }
        }
    }
}


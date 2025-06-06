package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
                    composable("greeting") {
                        GreetingScreen(
                            onNavigate = { route -> navController.navigate(route) }
                        )
                    }
                    composable("ManagePlants") {
                        ManagePlants(
                            onBack = { navController.popBackStack() },
                            onPlant = { Toast.makeText(this@MainActivity, "Planted a new flower!", Toast.LENGTH_SHORT).show() }
                        )
                    }
                    composable("WaterPlants") {
                        WaterPlants(
                            onBack = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun GreetingScreen(onNavigate: (String) -> Unit){
    Surface(
        color = Color(174, 200, 164),
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxSize().padding(top = 64.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.flowerroseplant),
                contentDescription = "App Icon",
                modifier = Modifier.size(120.dp).padding(bottom = 16.dp),
                contentScale = ContentScale.Fit
            )

            Text(
                "Hi, Welcome To Flowery!",
                color = Color(59, 59, 26),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {onNavigate("ManagePlants") },
                colors =  ButtonDefaults.buttonColors(Color(59, 59, 26))) {
                Text("Add/Remove Plants")
            }
            Button(onClick = {onNavigate("WaterPlants")},
                colors =  ButtonDefaults.buttonColors(Color(59, 59, 26))) {
                Text("Water Plants")
            }
        }

    }
}

@Composable
fun ManagePlants(onBack: () -> Unit, onPlant: () -> Unit) {
    Surface(
        color = Color(231, 239, 199),
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxSize().padding(top = 64.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.gardeningtools),
                contentDescription = "App Icon",
                modifier = Modifier.size(120.dp).padding(bottom = 16.dp),
                contentScale = ContentScale.Fit
            )

            Text("Wanna add some flowers? Cant yet!",
                color = Color(59, 59, 26),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onPlant,
                colors =  ButtonDefaults.buttonColors(Color(1, 59, 26))) {
                Text("Plant")
            }
            Button(onClick = onBack,
                colors =  ButtonDefaults.buttonColors(Color(59, 59, 26))) {
                Text("Go back")
            }
        }
    }
}

@Composable
fun WaterPlants(onBack: () -> Unit) {
    Surface(
        color = Color(231, 239, 199),
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxSize().padding(top = 64.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.watercan),
                contentDescription = "App Icon",
                modifier = Modifier.size(120.dp).padding(bottom = 16.dp),
                contentScale = ContentScale.Fit
            )

            Text("Wanna Water some flowers? Cant yet!",
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


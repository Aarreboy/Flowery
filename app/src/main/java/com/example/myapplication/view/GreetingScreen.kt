package com.example.myapplication.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Composable
fun GreetingScreen(onNavigate: (String) -> Unit) {
    Surface(
        color = Color(174, 200, 164),
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 64.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.flowerroseplant),
                contentDescription = "App Icon",
                modifier = Modifier
                    .size(120.dp)
                    .padding(bottom = 16.dp),
                contentScale = ContentScale.Fit
            )

            Text(
                "Hi, Welcome To Flowery!",
                color = Color(59, 59, 26),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { onNavigate("ManagePlants") },
                colors = ButtonDefaults.buttonColors(Color(59, 59, 26))
            ) {
                Text("Add/Remove Plants")
            }
            Button(
                onClick = { onNavigate("WaterPlants") },
                colors = ButtonDefaults.buttonColors(Color(59, 59, 26))
            ) {
                Text("Water Plants")
            }
        }
    }
}

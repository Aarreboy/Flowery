package com.example.myapplication.view

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
import com.example.myapplication.R
import com.example.myapplication.viewmodel.PlantViewModel

@Composable
fun WaterPlants(onBack: () -> Unit, viewModel: PlantViewModel) {
    val plants = viewModel.plants
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

            Text(
                "Your Plants 🌱",
                color = Color(59, 59, 26),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (plants.isEmpty()) {
                Text("No plants yet!", color = Color.DarkGray)
            } else {
                plants.forEach { plant ->
                    Text(
                        text = "🌼 ${plant.name}",
                        fontSize = 18.sp,
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = onBack,
                colors =  ButtonDefaults.buttonColors(Color(59, 59, 26))) {
                Text("Go back")
            }
        }
    }
}
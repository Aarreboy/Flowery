package com.example.myapplication.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.viewmodel.PlantViewModel
import com.example.myapplication.utils.timeAgo
import androidx.compose.foundation.lazy.items




@Composable
fun WaterPlants(onBack: () -> Unit, viewModel: PlantViewModel) {
    val plants = viewModel.plants
    val context = LocalContext.current
    Surface(
        color = Color(231, 239, 199),
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 64.dp)
        ) {
            // Header (image, title, spacer)
            item {
                Image(
                    painter = painterResource(id = R.drawable.watercan),
                    contentDescription = "App Icon",
                    modifier = Modifier
                        .size(120.dp)
                        .padding(bottom = 16.dp),
                    contentScale = ContentScale.Fit
                )

                Text(
                    "Your Plants 🌱",
                    color = Color(59, 59, 26),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))
            }
            // Go back button
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = onBack,
                    colors = ButtonDefaults.buttonColors(Color(59, 59, 26))
                ) {
                    Text("Go back")
                }
            }

            // If no plants
            if (plants.isEmpty()) {
                item {
                    Text("No plants yet!", color = Color.DarkGray)
                }
            }

            // Plant list
            items(plants) { plant ->
                Column(
                    modifier = Modifier.padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("🌼 ${plant.name}", fontSize = 18.sp)
                    Text(
                        "Last Watered : ${timeAgo(plant.lastWatered)}",
                        fontSize = 14.sp,
                        color = Color.DarkGray
                    )
                    Button(
                        onClick = {
                            viewModel.waterPlant(plant)
                            Toast.makeText(context, "Watered ${plant.name}", Toast.LENGTH_SHORT)
                                .show()
                        },
                        colors = ButtonDefaults.buttonColors(Color(1, 59, 26))
                    ) {
                        Text("Water")
                    }
                }
            }
        }
    }
}
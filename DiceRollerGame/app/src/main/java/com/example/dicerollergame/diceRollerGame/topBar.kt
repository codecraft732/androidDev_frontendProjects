package com.example.dicerollergame.diceRollerGame

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.dicerollergame.navigation.Routes
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MytopBar(navController: NavHostController) {
        TopAppBar(
            title = {
                Text(
                    text = "Dice Rolling Game",
                    fontWeight = FontWeight.Bold
                )
            },
            actions = {
                Button(
                    onClick = {
                        navController.navigate(Routes.PlayersScreenR)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    ),
                    modifier = Modifier.padding(end = 14.dp),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 10.dp
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(text = "New Game")
                }
            }
        )
    }


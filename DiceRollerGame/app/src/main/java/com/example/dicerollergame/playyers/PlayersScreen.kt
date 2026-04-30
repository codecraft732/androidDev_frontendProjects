package com.example.dicerollergame.playyers

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.dicerollergame.R
import com.example.dicerollergame.navigation.Routes


@Composable
fun Players(navController: NavController) {
    var player1 by rememberSaveable { mutableStateOf("") }
    var player2 by rememberSaveable { mutableStateOf("") }
    var context = LocalContext.current
    var selectedScore by rememberSaveable { mutableStateOf(50) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {


        Image(
            painter = painterResource
                (
                id = R.drawable.dice
            ),
            contentDescription = null,
            modifier = Modifier.padding(top = 68.dp)
                .fillMaxWidth(0.4f)
                .aspectRatio(1f)

        )



        Text(
            text = "Enter Names of Players",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            TextField(
                value = player1,
                onValueChange = { if (it.length <= 3) player1 = it
                    if(it.length > 3)
                    Toast.makeText(context,
                        "Name should be 3 characters",
                        Toast.LENGTH_SHORT).show()},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                placeholder = { Text("Enter Player1 Name", color = Color.LightGray) },
                label = { Text("Player 01") },
                textStyle = TextStyle(fontSize = 19.sp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Gray
                )

            )


            TextField(
                value = player2,
                onValueChange = { if (it.length <= 3) player2 = it
                    if(it.length > 3)
                    Toast.makeText(context,
                        "Name should be 3 characters",
                        Toast.LENGTH_SHORT).show()
                                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),

                placeholder = { Text(text = "Enter Player2 name", color = Color.LightGray) },
                label = { Text("Player 02") },
                textStyle = TextStyle(fontSize = 19.sp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Gray
                )
            )
        }

        //  Spacer(modifier = Modifier.weight(0.01f))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Text(
                    text = "Select Score",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )



                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(40.dp)
                            .background(
                                color = if (selectedScore == 50) Color.Black else Color.LightGray,
                                shape = RoundedCornerShape(30.dp)
                            )
                            .clickable { selectedScore = 50 },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "50",
                            color = if (selectedScore == 50) Color.White else Color.Gray,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }



                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(40.dp)
                            .background(
                                color = if (selectedScore == 100) Color.Black else Color.LightGray,
                                shape = RoundedCornerShape(30.dp)
                            )
                            .clickable { selectedScore = 100 },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "100",
                            color = if (selectedScore == 100) Color.White else Color.Gray,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

            }
        }

        Button(
            onClick = {
                navController.navigate(
                    Routes.GameScreenR(
                        player1 = player1,
                        player2 = player2,
                        totalScore = selectedScore
                    )
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                //.height(55.dp)
                .padding(horizontal = 16.dp, vertical = 4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp),
            enabled = player1.isNotBlank() && player2.isNotBlank()
                    && player1 != player2

        ) {
            Text(
                text = "Start Game",
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold
            )
        }


    }
}
package com.example.dicerollergame.diceRollerGame

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.dicerollergame.navigation.Routes
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun GameScreen(
    player1: String,
    player2: String,
    totalScore: Int,
    navController: NavHostController
) {

    var diceValue by remember { mutableStateOf(1) }
    var isRolling by remember { mutableStateOf(false) }
    var isPlayer1Turn by remember { mutableStateOf(true) }

    var player1Score by remember { mutableStateOf(0) }
    var player2Score by remember { mutableStateOf(0) }

    val scope = rememberCoroutineScope()
    val rotation = remember { Animatable(0f) }
    Scaffold(
        topBar ={MytopBar(navController)}
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(0.1f))

            Text(
                text = "Let's Play!",
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(modifier = Modifier.weight(0.03f))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    //.height(45.dp)
                    .background(
                        color = Color.Black,
                        shape = RoundedCornerShape(2.dp)
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "$player1 Score: $player1Score",
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium

                    )
                    Text(
                        text = "$player2 Score: $player2Score",
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium

                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    when (diceValue
                    ) {
                        1 -> dice1()
                        2 -> dice2()
                        3 -> dice3()
                        4 -> dice4()
                        5 -> dice5()
                        6 -> dice6()
                    }

                }
            }
            Spacer(modifier = Modifier.weight(0.1f))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp)
            ) {
                Button(
                    onClick = {
                        if (!isRolling) {
                            isRolling = true
                            scope.launch {
                                repeat(5) {
                                    diceValue = (1..6).random()
                                    rotation.animateTo(
                                        180f,
                                        tween(50)
                                    )
                                    rotation.snapTo(0f)
                                    delay(40)
                                }

                                diceValue = (1..6).random()
                                player1Score += diceValue
                                isRolling = false
                                isPlayer1Turn = false
                                if (diceValue == 6) isPlayer1Turn = true
                                if(player1Score>=totalScore){
                                    navController.navigate(Routes.WinningScreenR(name =  player1 )
                                    )
                                    return@launch
                                }
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp),
                    shape = RoundedCornerShape(4.dp),
                    enabled = isPlayer1Turn
                )
                {
                    Text(text = player1)
                }
                Button(
                    onClick = {

                        if (!isRolling) {
                            isRolling = true
                            scope.launch {
                                repeat(5) {
                                    diceValue = (1..6).random()
                                    rotation.animateTo(
                                        180f,
                                        tween(50)
                                    )
                                    rotation.snapTo(0f)
                                    delay(40)

                                }
                                diceValue = (1..6).random()
                                player2Score += diceValue
                                isRolling = false
                                isPlayer1Turn = true
                                if (diceValue == 6) isPlayer1Turn = false
                                if(player2Score>=totalScore){
                                    navController.navigate(Routes.WinningScreenR(name =  player2 )
                                    )
                                    return@launch
                            }
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp),
                    shape = RoundedCornerShape(4.dp),
                    enabled = !isPlayer1Turn
                ) {
                    Text(text = player2)
                }


            }


        }

    }

}


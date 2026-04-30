package com.example.tictactoegame.View

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tictactoegame.Data.CellState

@Composable
fun Cell(
    state: CellState,
    highlight: Boolean,
    onClick: () -> Unit,
    modifier: Modifier=Modifier
) {
    val bgColor = if (highlight) Color.Green else Color.White

    Card(
        modifier = Modifier
            .aspectRatio(1f)
            .clickable(enabled = state == CellState.EMPTY) {
                onClick()
            }
            .padding(3.dp),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = bgColor
        )

    ) {
        Box(modifier=Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center){

            Text(
                text = when (state){
                    CellState.PLAYER_X -> "X"
                    CellState.PLAYER_O -> "O"
                    else -> ""
                },
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = when(state){

                    CellState.PLAYER_X -> Color.Black
                    CellState.PLAYER_O -> Color.Red
                    else -> Color.Transparent
                }
            )
        }
    }

}
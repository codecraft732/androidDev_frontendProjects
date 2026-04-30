package com.example.tictactoegame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.tictactoegame.View.TicTacToeGame
import com.example.tictactoegame.ui.theme.TicTacToeGameTheme
import com.example.tictactoegame.viewModel.GameViewModel

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<GameViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TicTacToeGameTheme {
                TicTacToeGame(viewModel)
                }
        }
    }
}


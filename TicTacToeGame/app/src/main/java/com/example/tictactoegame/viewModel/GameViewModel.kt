package com.example.tictactoegame.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.tictactoegame.Data.CellState
import com.example.tictactoegame.Data.GameStatus
import com.example.tictactoegame.Data.Player


class GameViewModel : ViewModel() {
    //board 3*3
    var board = mutableStateListOf(
        mutableStateListOf(CellState.EMPTY, CellState.EMPTY, CellState.EMPTY),
        mutableStateListOf(CellState.EMPTY, CellState.EMPTY, CellState.EMPTY),
        mutableStateListOf(CellState.EMPTY, CellState.EMPTY, CellState.EMPTY),
    )
        private set
    var current_Player = mutableStateOf(Player.PLAYER_X)
        private set
    var gameStatus = mutableStateOf(GameStatus.ONGOING)
        private set
    var massage = mutableStateOf("TURN_X")
        private set
    var winningCells = mutableStateListOf<Pair<Int, Int>>()
        private set

    fun makeMove(row: Int, col: Int) {
        if (gameStatus.value != GameStatus.ONGOING) return
        if (board[row][col] != CellState.EMPTY) return

        //cellState
        board[row][col] = if (current_Player.value == Player.PLAYER_X) CellState.PLAYER_X
        else CellState.PLAYER_O

        //SwitchPlayer
        current_Player.value = if (current_Player.value == Player.PLAYER_X) Player.PLAYER_O
        else Player.PLAYER_X
        massage.value = "TURN_${current_Player.value.name}"


        //check win
        val winner = checkWinner()
        if (winner != null) {
            gameStatus.value = if (winner == Player.PLAYER_X) GameStatus.PLAYER_X_WON
            else GameStatus.PLAYER_O_WON
            massage.value = "${winner.name} Won!"
            return
        }

        //check Draw
        if (isBoardFull()) {
            gameStatus.value = GameStatus.DRAW
            massage.value = "it's a DRAW"
            return
        }

    }


    private fun checkWinner(): Player? {

        //for row
        for (row in 0..2) {
            if (board[row][0] != CellState.EMPTY
                && board[row][0] == board[row][1]
                && board[row][1] == board[row][2]
            ) {
                winningCells.addAll(
                    listOf(
                        Pair(row, 0),
                        Pair(row, 1),
                        Pair(row, 2)
                    )
                )
                return if (board[row][0] == CellState.PLAYER_X) Player.PLAYER_X
                else Player.PLAYER_O
            }
        }
        //for column
        for (col in 0..2) {
            if (board[0][col] != CellState.EMPTY
                && board[0][col] == board[1][col]
                && board[1][col] == board[2][col]
            ) {
                winningCells.addAll(
                    listOf(
                        Pair(0, col),
                        Pair(1, col),
                        Pair(2, col)
                    )
                )
                return if (board[0][col] == CellState.PLAYER_X) Player.PLAYER_X
                else Player.PLAYER_O
            }
        }
        //for diagonal
        for (col in 0..2) {
            if (board[0][0] != CellState.EMPTY
                && board[0][0] == board[1][1]
                && board[1][1] == board[2][2]
            ) {
                winningCells.addAll(
                    listOf(
                        Pair(0, 0),
                        Pair(1, 1),
                        Pair(2, 2)
                    )
                )
                return if (board[0][0] == CellState.PLAYER_X) Player.PLAYER_X
                else Player.PLAYER_O
            }
        }
        //for diagonal opposite
        for (col in 0..2) {
            if (board[0][2] != CellState.EMPTY
                && board[0][2] == board[1][1]
                && board[1][1] == board[2][0]
            ) {
                winningCells.addAll(
                    listOf(
                        Pair(0, 2),
                        Pair(1, 1),
                        Pair(2, 0)
                    )
                )
                return if (board[0][2] == CellState.PLAYER_X) Player.PLAYER_X
                else Player.PLAYER_O
            }
        }
        return null
    }

    private fun isBoardFull(): Boolean {
        return board.all { row ->
            row.all { cell ->
                cell != CellState.EMPTY
            }
        }
    }


    fun restartGame() {
        winningCells.clear()
        for (row in 0..2) {
            for (col in 0..2) {
                board[row][col] = CellState.EMPTY
            }
        }
        current_Player.value = Player.PLAYER_X
        gameStatus.value = GameStatus.ONGOING
        massage.value = "TURN_X"
    }
}
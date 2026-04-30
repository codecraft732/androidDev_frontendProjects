package com.example.tictactoegame.Data

enum class Player {
    PLAYER_X,
    PLAYER_O
}

enum class GameStatus {
    ONGOING,
    DRAW,
    PLAYER_X_WON,
    PLAYER_O_WON

}

enum class CellState {
    EMPTY,
    PLAYER_X,
    PLAYER_O

}
package com.example.dicerollergame.navigation

import kotlinx.serialization.Serializable
@Serializable
sealed class Routes {


    @Serializable
    object PlayersScreenR: Routes()

    @Serializable
    data class GameScreenR(
        val player1: String,
        val player2: String,
        val totalScore: Int
    ) : Routes()

    @Serializable
    data class WinningScreenR(val name: String) : Routes()


}
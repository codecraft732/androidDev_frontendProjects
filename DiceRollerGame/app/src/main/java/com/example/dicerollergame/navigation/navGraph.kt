package com.example.dicerollergame.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.dicerollergame.diceRollerGame.GameScreen
import com.example.dicerollergame.playyers.Players
import com.example.dicerollergame.winning.WinningScreen

@Composable
fun NavGraph(navController: NavHostController){

    NavHost(
        navController = navController,
        startDestination = Routes.PlayersScreenR
    ){
        composable<Routes.PlayersScreenR>{
            Players(navController)
        }

        composable<Routes.GameScreenR>{
                backStackEntry ->
            val args = backStackEntry.toRoute<Routes.GameScreenR>()
            GameScreen(
                player1 = args.player1,
                player2 = args.player2,
                totalScore = args.totalScore, navController)
        }
        composable<Routes.WinningScreenR>{
                backStackEntry ->
            val args = backStackEntry.toRoute<Routes.WinningScreenR>()
            WinningScreen(
              name = args.name, navController
            )
        }
    }

}
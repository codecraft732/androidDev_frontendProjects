package com.example.coffeeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coffeeapp.UiScreens.*
import com.example.coffeeapp.data.Coffee
import com.example.coffeeapp.ui.theme.CoffeeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoffeeAppTheme {
                CoffeeAppNavigation()
            }
        }
    }
}

@Composable
fun CoffeeAppNavigation() {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") {
            WelcomeScreen(onGetStarted = {
                navController.navigate("home")
            })
        }
        composable("home") {
            HomeScreen(
                onCoffeeClick = { coffee ->
                    // For simplicity, passing ID as route, or you can pass object if using Nav 2.8+ type safe nav
                    navController.navigate("detail/${coffee.id}")
                },
                onWishlistClick = { navController.navigate("wishlist") },
                onCartClick = { navController.navigate("order_summary") },
                onProfileClick = { navController.navigate("profile") }
            )
        }
        composable("detail/{coffeeId}") { backStackEntry ->
            val coffeeId = backStackEntry.arguments?.getString("coffeeId")?.toIntOrNull()
            // Sample data lookup
            val coffee = getSampleCoffee(coffeeId ?: 1)
            CoffeeDetailScreen(coffee = coffee, onBack = { navController.popBackStack() })
        }
        composable("wishlist") {
            WishlistScreen()
        }
        composable("order_summary") {
            OrderSummaryScreen()
        }
        composable("profile") {
            ProfileScreen(onBack = { navController.popBackStack() })
        }
    }
}

// Helper to get sample data for navigation
fun getSampleCoffee(id: Int): Coffee {
    val coffeeList = listOf(
        Coffee(1, "Cappuccino", "With Chocolate", 4.53, 4.8, 230, R.drawable.coffee_1, "Cappuccino"),
        Coffee(2, "Espresso", "Strong and rich", 3.8, 4.9, 150, R.drawable.coffee_2, "Espresso"),
        Coffee(3, "Mocha", "Smooth and creamy", 4.0, 4.7, 180, R.drawable.coffee_3, "Mocha"),
        Coffee(4, "Latte", "Milk and coffee", 4.2, 4.6, 200, R.drawable.coffee_4, "Latte"),
        Coffee(5, "Flat White", "Velvety texture", 4.3, 4.5, 120, R.drawable.coffee_5, "Flat White"),
        Coffee(6, "Americano", "Classic black", 3.5, 4.4, 90, R.drawable.coffee_6, "Americano")
    )
    return coffeeList.find { it.id == id } ?: coffeeList[0]
}

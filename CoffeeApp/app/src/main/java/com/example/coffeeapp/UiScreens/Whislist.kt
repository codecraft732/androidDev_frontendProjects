package com.example.coffeeapp.UiScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeapp.R
import com.example.coffeeapp.data.Coffee

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WishlistScreen() {
    val wishlistItems = listOf(
        Coffee(1, "Cappuccino", "With Chocolate", 4.53, 4.8, 230, R.drawable.coffee_1, "Cappuccino"),
        Coffee(2, "Espresso", "Strong and rich", 3.8, 4.9, 150, R.drawable.coffee_2, "Espresso"),
        Coffee(3, "Mocha", "Smooth and creamy", 4.0, 4.7, 180, R.drawable.coffee_3, "Mocha")
    )

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Wishlist", fontWeight = FontWeight.Bold) })
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(wishlistItems) { coffee ->
                WishlistItem(coffee)
            }
        }
    }
}

@Composable
fun WishlistItem(coffee: Coffee) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(16.dp))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = coffee.image),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = coffee.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = coffee.description, color = Color.Gray, fontSize = 12.sp)
        }
        IconButton(onClick = { /* TODO: Remove from wishlist */ }) {
            Icon(Icons.Default.Delete, contentDescription = "Delete", tint = Color.Red)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WishlistScreenPreview() {
    WishlistScreen()
}

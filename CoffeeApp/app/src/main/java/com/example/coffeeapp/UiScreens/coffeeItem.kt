package com.example.coffeeapp.UiScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
fun CoffeeDetailScreen(coffee: Coffee, onBack: () -> Unit) {
    var selectedSize by remember { mutableStateOf("M") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detail", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(Icons.Default.FavoriteBorder, contentDescription = "Favorite")
                    }
                }
            )
        },
        bottomBar = {
            DetailBottomBar(coffee.price)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = coffee.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = coffee.name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = coffee.description, fontSize = 14.sp, color = Color.Gray)
            
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(vertical = 8.dp)) {
                Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFFFFC107), modifier = Modifier.size(20.dp))
                Text(text = " ${coffee.rating}", fontWeight = FontWeight.Bold)
                Text(text = " (${coffee.reviews})", color = Color.Gray, fontSize = 12.sp)
            }
            
            HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
            
            Text(text = "Description", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "A cappuccino is an approximately 150 ml (5 oz) beverage, with 25 ml of espresso coffee and 85ml of fresh milk the fo...",
                color = Color.Gray,
                lineHeight = 20.sp
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "Size", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(12.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                SizeOption("S", selectedSize == "S") { selectedSize = "S" }
                SizeOption("M", selectedSize == "M") { selectedSize = "M" }
                SizeOption("L", selectedSize == "L") { selectedSize = "L" }
            }
        }
    }
}

@Composable
fun SizeOption(size: String, isSelected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .width(100.dp)
            .height(44.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(if (isSelected) Color(0xFFFFF5EE) else Color.White)
            .clickable(onClick = onClick)
            .then(
                if (isSelected) Modifier.background(Color(0xFFDEA580).copy(alpha = 0.1f)) 
                else Modifier.background(Color.Transparent)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = size,
            color = if (isSelected) Color(0xFFDEA580) else Color.Black,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun DetailBottomBar(price: Double) {
    Surface(shadowElevation = 8.dp) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = "Price", color = Color.Gray, fontSize = 14.sp)
                Text(text = "$ $price", color = Color(0xFFDEA580), fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
            Button(
                onClick = { /* TODO */ },
                modifier = Modifier.width(200.dp).height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDEA580))
            ) {
                Text(text = "Add to Cart", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CoffeeDetailScreenPreview() {
    val coffee = Coffee(1, "Cappuccino", "With Chocolate", 4.53, 4.8, 230, R.drawable.coffee_1, "Cappuccino")
    CoffeeDetailScreen(coffee = coffee, onBack = {})
}

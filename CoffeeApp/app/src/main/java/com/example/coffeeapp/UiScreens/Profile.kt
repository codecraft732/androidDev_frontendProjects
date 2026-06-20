package com.example.coffeeapp.UiScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray)
            ) {
                // Placeholder for profile image
                Icon(
                    Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize().padding(20.dp),
                    tint = Color.Gray
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Mohammad Anas", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = "anas@example.com", fontSize = 14.sp, color = Color.Gray)

            Spacer(modifier = Modifier.height(32.dp))

            AddressSection()

            Spacer(modifier = Modifier.height(24.dp))

            MenuItem(icon = Icons.Default.ShoppingBag, title = "Orders")
            MenuItem(icon = Icons.Default.Favorite, title = "Favorites")
            MenuItem(icon = Icons.Default.Settings, title = "Settings")
        }
    }
}

@Composable
fun AddressSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF5F5F5), RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.LocationOn, contentDescription = null, tint = Color(0xFFDEA580))
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Address", fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Janatha Rd, Palarivattom, Ernakulam, Kerala - 682025",
            fontSize = 14.sp,
            color = Color.DarkGray
        )
    }
}

@Composable
fun MenuItem(icon: ImageVector, title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = null, modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = title, fontSize = 16.sp)
        }
        Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(onBack = {})
}

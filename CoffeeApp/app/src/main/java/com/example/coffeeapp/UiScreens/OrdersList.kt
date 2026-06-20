package com.example.coffeeapp.UiScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun OrderSummaryScreen() {
    val cartItems = remember {
        mutableStateListOf(

            Coffee(
                1,
                "Espresso",
                "Strong and rich",
                3.8,
                4.9,
                150,
                R.drawable.coffee_2,
                "Espresso"
            ),

            Coffee(
                2,
                "Latte",
                "Smooth and creamy",
                4.5,
                4.7,
                180,
                R.drawable.coffee_5,
                "Latte"
            )
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title =
                    {
                        Text("Order", fontWeight = FontWeight.Bold)
                    }
            )
        },
        bottomBar = {
            OrderBottomSection()
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            DeliverToggle()
            Spacer(modifier = Modifier.height(24.dp))
            LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                items(cartItems) { coffee ->
                    CartItem(coffee)
                }
            }
        }
    }
}

@Composable
fun DeliverToggle() {
    var isDeliverSelected by remember { mutableStateOf(true) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(Color(0xFFF5F5F5), RoundedCornerShape(12.dp))
            .padding(4.dp)
    ) {
        Button(
            onClick = { isDeliverSelected = true },
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isDeliverSelected)
                    Color(0xFFDEA580)
                else
                    Color.Transparent,
                contentColor = if (isDeliverSelected)
                    Color.White
                else
                    Color.Gray
            )
        ) {
            Text("Deliver")
        }
        Button(
            onClick = { isDeliverSelected = false },
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (!isDeliverSelected)
                    Color(0xFFDEA580)
                else
                    Color.Transparent,
                contentColor = if (!isDeliverSelected)
                    Color.White
                else
                    Color.Gray
            )
        ) {
            Text("Pick Up")
        }
    }
}

@Composable
fun CartItem(coffee: Coffee) {
    var quantity by remember { mutableStateOf(1) }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = coffee.image),
            contentDescription = null,
            modifier = Modifier
                .size(54.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f))
        {
            Text(
                text = coffee.name,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = coffee.description,
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(
                onClick = { if (quantity > 1) quantity-- },
                modifier = Modifier.size(32.dp)
            ) {
                Icon(Icons.Default.Remove, contentDescription = null, tint = Color.Gray)
            }
            Text(
                text = "$quantity",
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            IconButton(
                onClick = { quantity++ },
                modifier = Modifier.size(32.dp)
            ) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
        }
    }
}

@Composable
fun OrderBottomSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(24.dp)
    ) {
        Text("Payment Summary", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Spacer(modifier = Modifier.height(12.dp))
        SummaryRow("Price", "$12.5")
        SummaryRow("Delivery Fee", "$1.0")
        HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))
        SummaryRow("Total Payment", "$13.5", isTotal = true)
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDEA580))
        ) {
            Text("Place Order", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}



@Composable
fun SummaryRow(label: String, value: String, isTotal: Boolean = false) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            color = if (isTotal) Color.Black else Color.Gray,
            fontWeight = if (isTotal) FontWeight.Bold else FontWeight.Normal
        )
        Text(
            text = value,
            fontWeight = FontWeight.Bold,
            color = if (isTotal) Color(0xFFDEA580) else Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OrderSummaryScreenPreview() {
    OrderSummaryScreen()
}

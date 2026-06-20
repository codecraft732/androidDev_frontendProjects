package com.example.coffeeapp.UiScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import com.example.coffeeapp.ui.theme.CoffeeAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onCoffeeClick: (Coffee) -> Unit,
    onWishlistClick: () -> Unit,
    onCartClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    val categories = listOf("All Coffee", "Machiato", "Latte", "Americano", "Cappuccino")
    var selectedCategory by remember { mutableStateOf("All Coffee") }

    val coffeeList = listOf(
        Coffee(
            1,
            "Cappuccino",
            "With Chocolate",
            4.53,
            4.8,
            230,
            R.drawable.coffee_1,
            "Cappuccino"
        ),
        Coffee(
            2,
            "Espresso",
            "Strong and rich",
            3.8, 4.9, 150,
            R.drawable.coffee_2,
            "Espresso"
        ),
        Coffee(
            3,
            "Mocha",
            "Smooth and creamy",
            4.0,
            4.7, 180, R.drawable.coffee_3,
            "Mocha"
        ),
        Coffee(
            4,
            "Latte",
            "Milk and coffee",
            4.2,
            4.6,
            200,
            R.drawable.coffee_4,
            "Latte"
        ),
        Coffee(
            5,
            "Flat White",
            "Velvety texture",
            4.3,
            4.5,
            120,
            R.drawable.coffee_5,
            "Flat White"
        ),
        Coffee(
            6,
            "Americano",
            "Classic black",
            3.5,
            4.4,
            90,
            R.drawable.coffee_6,
            "Americano"
        )
    )

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                onHomeClick = {},
                onWishlistClick = onWishlistClick,
                onCartClick = onCartClick,
                onProfileClick = onProfileClick
            )
        }) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
        ) {
            // Dark background for the top section (halfway through the banner)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
                    .background(Color(0xFF1C1C1C))
            )

            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                HeaderSection()

                Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                    SearchBar()
                    Spacer(modifier = Modifier.height(16.dp))
                    PromoBanner()
                    Spacer(modifier = Modifier.height(24.dp))
                    CategoryChips(categories, selectedCategory) { selectedCategory = it }
                    Spacer(modifier = Modifier.height(16.dp))
                }

                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 160.dp),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    contentPadding = PaddingValues(bottom = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(coffeeList) { coffee ->
                        CoffeeCard(coffee, onClick = { onCoffeeClick(coffee) })
                    }
                }
            }
        }
    }
}

@Composable
fun HeaderSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp, start = 12.dp, end = 12.dp, bottom = 16.dp)
    ) {
        Text(
            text = "Location", color = Color.Gray,
            style = MaterialTheme.typography.titleSmall
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Janatha Rd, Palarivattom",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium
            )
            Icon(Icons.Default.KeyboardArrowDown, contentDescription = null, tint = Color.White)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .weight(1f)
                .height(52.dp),
            placeholder = { Text("Search coffee", color = Color.Gray) },
            leadingIcon = {
                Icon(
                    Icons.Default.Search, contentDescription = null, tint = Color.White
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF313131),
                unfocusedContainerColor = Color(0xFF313131),
                disabledContainerColor = Color(0xFF313131),
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                cursorColor = Color.White
            ),
            shape = RoundedCornerShape(12.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Box(
            modifier = Modifier
                .size(46.dp)
                .background(
                    Color(0xFFDEA580),
                    RoundedCornerShape(12.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.regular_outline_filter),
                contentDescription = null,
                tint = Color.White, modifier = Modifier
                    .size(24.dp)
            )
        }
    }
}

@Composable
fun PromoBanner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        Image(
            painter = painterResource(id = R.drawable.banner_1),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}


@Composable
fun CategoryChips(categories: List<String>, selected: String, onSelect: (String) -> Unit) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(categories) { category ->
            val isSelected = category == selected
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(if (isSelected) Color(0xFFDEA580) else Color.White)
                    .clickable { onSelect(category) }
                    .padding(horizontal = 12.dp, vertical = 6.dp)) {
                Text(
                    text = category,
                    style = MaterialTheme.typography.titleSmall,
                    color = if (isSelected) Color.White else Color.Black,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                )
            }
        }
    }
}

@Composable
fun CoffeeCard(coffee: Coffee, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column {
            Box {
                Image(
                    painter = painterResource(id = coffee.image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(130.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )
                Row(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(8.dp)
                        .background(Color.Black.copy(alpha = 0.3f), RoundedCornerShape(8.dp))
                        .padding(horizontal = 4.dp), verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.Star,
                        contentDescription = null,
                        tint = Color(0xFFFFC107),
                        modifier = Modifier.size(12.dp)
                    )
                    Text(
                        text = " ${coffee.rating}",
                        color = Color.White,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = coffee.name, fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = coffee.description,
                    color = Color.Gray,
                    style = MaterialTheme.typography.titleSmall
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "$ ${coffee.price}",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleSmall,
                        color = Color(0xFFDEA580)
                    )
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .background(
                                Color(0xFFDEA580),
                                RoundedCornerShape(8.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            Icons.Default.Add,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(14.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(
    onHomeClick: () -> Unit,
    onWishlistClick: () -> Unit,
    onCartClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    NavigationBar(containerColor = Color.White) {
        NavigationBarItem(
            selected = true,
            onClick = onHomeClick,
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            label = {
                Text(
                    "Home",
                    style = MaterialTheme.typography.titleSmall
                )
            })
        NavigationBarItem(
            selected = false,
            onClick = onWishlistClick,
            icon = { Icon(Icons.Default.FavoriteBorder, contentDescription = null) },
            label = {
                Text(
                    "Wishlist",
                    style = MaterialTheme.typography.titleSmall
                )
            })
        NavigationBarItem(
            selected = false,
            onClick = onCartClick,
            icon = { Icon(Icons.Default.ShoppingBag, contentDescription = null) },
            label = {
                Text(
                    "Cart",
                    style = MaterialTheme.typography.titleSmall
                )
            })
        NavigationBarItem(
            selected = false,
            onClick = onProfileClick,
            icon = { Icon(Icons.Default.Person, contentDescription = null) },
            label = {
                Text(
                    "Profile",
                    style = MaterialTheme.typography.titleSmall
                )
            })
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    CoffeeAppTheme {
        HomeScreen(onCoffeeClick = {}, onWishlistClick = {}, onCartClick = {}, onProfileClick = {})
    }
}

package com.example.instagram

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


val list = listOf<stories>(
    stories("Your Story", R.drawable.aklogo),
    stories("cuteAlmond", R.drawable.cutealmond),
    stories("google", R.drawable.googlelogo),
    stories("googlePost", R.drawable.googlepost),
    stories("cupcake", R.drawable.cupcake),
    stories("cuteAlmond", R.drawable.desksetup),
        stories("ak", R.drawable.aklogo2)
)


@Composable
fun story(add: stories) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        val storyOuterCircleSize = 66.dp
        val storyProfileImageSize = 56.dp
        Box(
            modifier = Modifier.size(storyOuterCircleSize),
            contentAlignment = Alignment.Center
        ) {
            //Story Gradient Ring
            Canvas(modifier = Modifier.size(storyOuterCircleSize)) {
                val stroke = 6f
                drawCircle(
                    brush = Brush.sweepGradient(
                        colors = listOf(
                            Color(0xFFFFC107),
                            Color(0xFFDD2A7B),
                            Color(0xFF7A00C4),
                            Color(0xFFFFC107)
                        )
                    ),
                    radius = size.minDimension / 2f - stroke / 2,
                    style = Stroke(width = stroke)
                )
            }
            Image(
                painter = painterResource(id = add.image),
                contentDescription = add.name,
                modifier = Modifier
                    .size(storyProfileImageSize)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )


            if (add.name == "Your Story") {
                Box(
                    modifier = Modifier
                        .size(22.dp)
                        .align(Alignment.BottomEnd)
                        .offset(x = 2.dp, y = 2.dp)
                        .clip(CircleShape)
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "+",
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = add.name,
            color = MaterialTheme.colorScheme.onSurface,
            fontFamily = FontFamily.SansSerif,
            fontSize = 12.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

    }


}

@Composable
fun storyList() {

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(list.size) { index ->
            story(add = list[index])

        }
    }
}
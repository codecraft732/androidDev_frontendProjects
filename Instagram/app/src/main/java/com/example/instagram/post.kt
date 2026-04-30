package com.example.instagram

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagram.posts


val posts = listOf(
    Post(
        postUsername = "android_dev",
        postProfileImage = R.drawable.aklogo,
        postPhoto = R.drawable.desksetup,
        postCaption = "My Desk Setup",
        postHours = "2hr ago",
        postLikes = "100 likes"
    ),
    Post(
        postUsername = "Happy_Sweets",
        postProfileImage = R.drawable.cupcake,
        postPhoto = R.drawable.cutealmond,
        postCaption = "Eat sweets",
        postHours = "15hr ago",
        postLikes = "50 likes"
    ),
    Post(
        postUsername = "Online_Jobs",
        postProfileImage = R.drawable.image,
        postPhoto = R.drawable.workspace,
        postCaption = "WorkSpace",
        postHours = "yesterday",
        postLikes = "600 likes"
    ),
    Post(
        postUsername = "google",
        postProfileImage = R.drawable.googlelogo,
        postPhoto = R.drawable.googlepost,
        postCaption = "AI Mode ON",
        postHours = "5hrs ago",
        postLikes = "108k likes"
    )
)

@Composable
fun PostImageCard(post: Post) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = post.postProfileImage),
                    contentDescription = "Profile Pic",
                    modifier = Modifier
                        .size(42.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(10.dp))

                //Verified
                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = post.postUsername,
                            color = MaterialTheme.colorScheme.onSurface,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            fontFamily = FontFamily.SansSerif
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_verified_24),
                            contentDescription = "verified",
                            tint = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.size(14.dp)
                        )
                    }
                    Text(
                        text = post.postHours, color = MaterialTheme.colorScheme.onSurface,
                        fontSize = 15.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                }
                //Follow Button
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(Color(0xFF2E2E2E)),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
                    shape = RoundedCornerShape(30),
                    modifier = Modifier.height(36.dp)
                ) {
                    Text(text = "Follow", color = MaterialTheme.colorScheme.surface)
                }
                Spacer(modifier = Modifier.width(6.dp))

                //More Icon
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_more_vert_24),
                        tint = MaterialTheme.colorScheme.onSurface,
                        contentDescription = "More",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
            //Post Image
            Image(
                painter = painterResource(id = post.postPhoto),
                contentDescription = "Post Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(360.dp),
                contentScale = ContentScale.Crop
            )

            //Like, Comment, Share, Save
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_favorite_border_24),
                            contentDescription = "like",
                            tint = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.size(26.dp)
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(id = R.drawable.outline_mode_comment_24),
                            contentDescription = "comment",
                            tint = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.size(26.dp)
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_share_24),
                            tint = MaterialTheme.colorScheme.onSurface,
                            contentDescription = "Share",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_bookmark_border_24),
                        tint = MaterialTheme.colorScheme.onSurface,
                        contentDescription = "Save",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
            //Like Count, Caption, Comments
            Column(
                modifier = Modifier
                    .padding(
                        horizontal = 12.dp, vertical = 4.dp
                    )
            ) {
                Text(
                    text = post.postLikes,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif
                )
                Spacer(modifier = Modifier.height(6.dp))
                Row {
                    Text(
                        text = post.postUsername + " ",
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = post.postCaption,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "View all comments",
                    fontFamily = FontFamily.SansSerif,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}


@Composable
fun theme() {
    LazyColumn (
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(posts.size) { index ->
            PostImageCard(post = posts[index])

        }
    }
}
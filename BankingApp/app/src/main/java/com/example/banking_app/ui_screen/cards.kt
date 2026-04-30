package com.example.banking_app.ui_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.banking_app.Data.card
import com.example.banking_app.ui.theme.BlueEnd
import com.example.banking_app.ui.theme.BlueStart
import com.example.banking_app.ui.theme.GreenEnd
import com.example.banking_app.ui.theme.GreenStart
import com.example.banking_app.ui.theme.OrangeEnd
import com.example.banking_app.ui.theme.OrangeStart
import com.example.banking_app.ui.theme.PurpleEnd
import com.example.banking_app.ui.theme.PurpleStart


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun card_ui_preview() {
    cardList()
}

@Composable
fun cardList() {
    val cardItems = listOf(
        card(
            cardType = "VISA",
            cardNumber = "3664 7865 3786 3976",
            cardName = "Business",
            balance = 46.467,
            color = getGradient(PurpleStart, PurpleEnd),
        ),
        card(
            cardType = "MASTER CARD",
            cardNumber = "234 7583 7899 2223",
            cardName = "Savings",
            balance = 6.467,
            color = getGradient(BlueStart, BlueEnd),
        ),

        card(
            cardType = "VISA",
            cardNumber = "0078 3467 3446 7899",
            cardName = "School",
            balance = 3.467,
            color = getGradient(OrangeStart, OrangeEnd),
        ),

        card(
            cardType = "MASTER CARD",
            cardNumber = "3567 7865 3786 3976",
            cardName = "Trips",
            balance = 26.47,
            color = getGradient(GreenStart, GreenEnd),
        ),
    )


    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(cardItems.size) { index ->
            card_ui(cards = cardItems[index])
        }
    }
}


fun getGradient(
    startColor: Color,
    endColor: Color,
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )

}


@Composable
fun card_ui(cards: card) {
    var image = painterResource(id = com.example.banking_app.R.drawable.ic_visa)
    if (cards.cardType == "MASTER CARD") {
        image = painterResource(id = com.example.banking_app.R.drawable.ic_mastercard)
    }

        Column(
            modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .background(cards.color)
            .width(250.dp)
            .height(160.dp)
            .clickable {}
            .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween

        ) {
            Image(
                painter = image,
                contentDescription = "Master",
                modifier = Modifier.width(68.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "${cards.cardName}",
                fontFamily = FontFamily.SansSerif,
                fontSize = 16.sp
            )

            Text(
                text = "$ ${cards.balance}",
                fontFamily = FontFamily.SansSerif,
                fontSize = 16.sp
            )

            Text(
                text = "${cards.cardNumber}",
                fontFamily = FontFamily.SansSerif,
                fontSize = 16.sp
            )


        }

    }



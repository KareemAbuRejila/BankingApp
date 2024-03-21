package com.training.jetpack.bankingapp.presentation.home.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.training.jetpack.bankingapp.R
import com.training.jetpack.bankingapp.data.model.Card
import com.training.jetpack.bankingapp.data.model.CardType
import com.training.jetpack.bankingapp.ui.theme.BankingAppTheme
import com.training.jetpack.bankingapp.ui.theme.BlueEnd
import com.training.jetpack.bankingapp.ui.theme.BlueStart
import com.training.jetpack.bankingapp.ui.theme.GreenEnd
import com.training.jetpack.bankingapp.ui.theme.GreenStart
import com.training.jetpack.bankingapp.ui.theme.OrangeEnd
import com.training.jetpack.bankingapp.ui.theme.OrangeStart
import com.training.jetpack.bankingapp.ui.theme.PurpleEnd
import com.training.jetpack.bankingapp.ui.theme.PurpleStart

@Composable
fun CardsSection() {

    LazyRow {
        items(cards.size) { index -> CardItem(index) }
    }

}

@Composable
fun CardItem(
    index: Int
) {
    val card = cards[index]
    val lastItemPaddingEnd = if (index == cards.lastIndex) 0.dp
    else 14.dp

    var image = painterResource(
        id = if (card.cardType == CardType.Visa.type) R.drawable.ic_visa
        else R.drawable.ic_mastercard
    )

    Box(modifier = Modifier
        .padding(horizontal = 16.dp, vertical = 3.dp)
    ){
        Column(modifier= Modifier
            .clip(RoundedCornerShape(25.dp))
            .background(brush = card.color)
            .size(width = 250.dp, height = 160.dp)
            .clickable { }
            .shadow(2.dp)
            .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                modifier = Modifier.height(45.dp),
                contentDescription = "${card.cardName} Image",
                painter = image
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$ ${card.balance}",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


val cards = listOf(

    Card(
        cardType = CardType.Visa.type,
        cardNumber = "3664 7865 3786 3976",
        cardName = "Business",
        balance = 46.467,
        color = getGradient(PurpleStart, PurpleEnd),
    ),

    Card(
        cardType = "CardType.Master.type",
        cardNumber = "234 7583 7899 2223",
        cardName = "Savings",
        balance = 6.467,
        color = getGradient(BlueStart, BlueEnd),
    ),

    Card(
        cardType = CardType.Visa.type,
        cardNumber = "0078 3467 3446 7899",
        cardName = "School",
        balance = 3.467,
        color = getGradient(OrangeStart, OrangeEnd),
    ),

    Card(
        cardType = "CardType.Master.type",
        cardNumber = "3567 7865 3786 3976",
        cardName = "Trips",
        balance = 26.47,
        color = getGradient(GreenStart, GreenEnd),
    ),
)

fun getGradient(
    startColor: Color, endColor: Color
) = Brush.horizontalGradient(
    colors = listOf(startColor, endColor)
)

@Preview(showBackground = true)
@Composable
fun CardsSectionPreview() {
    BankingAppTheme {
        CardsSection()
    }
}
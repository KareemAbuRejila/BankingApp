package com.training.jetpack.bankingapp.data.model

import androidx.compose.ui.graphics.Brush

data class Card(
    val cardType: String,
    val cardNumber: String,
    val cardName: String,
    val balance: Double,
    val color: Brush
)

sealed class CardType(val type:String){
    data object Visa: CardType(type = "Visa")
    data object Master: CardType(type = "Master Card")

}

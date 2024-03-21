package com.training.jetpack.bankingapp.presentation.home.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.training.jetpack.bankingapp.data.model.Finance
import com.training.jetpack.bankingapp.ui.theme.BankingAppTheme
import com.training.jetpack.bankingapp.ui.theme.BlueStart
import com.training.jetpack.bankingapp.ui.theme.GreenStart
import com.training.jetpack.bankingapp.ui.theme.OrangeStart
import com.training.jetpack.bankingapp.ui.theme.PurpleStart

@Composable
fun FinanceSection(){

    Column {
        Text(
            text = "Finance",
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(16.dp)
        )
        LazyRow{
            items(financeList.size){
                FinanceItem(it)
            }
        }
    }
}

@Composable
fun FinanceItem(index: Int) {
    val item = financeList[index]
    val lastItemPaddingEnd = if (index == financeList.lastIndex) 0.dp
    else 14.dp

    Box(modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)){
        Column(
            modifier= Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .size(120.dp)
                .clickable { }
                .padding(13.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(item.background)
                .padding(6.dp)
            ){
                Icon(
                    imageVector = item.icon,
                    contentDescription = "${item.name} Icon"
                )
            }
            Text(text = item.name,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                style = MaterialTheme.typography.bodyMedium)
        }
    }
}


val financeList = listOf(
    Finance(
        icon = Icons.Rounded.StarHalf,
        name = "My\nBusiness",
        background = OrangeStart
    ),

    Finance(
        icon = Icons.Rounded.Wallet,
        name = "My\nWallet",
        background = BlueStart
    ),

    Finance(
        icon = Icons.Rounded.StarHalf,
        name = "Finance\nAnalytics",
        background = PurpleStart
    ),

    Finance(
        icon = Icons.Rounded.MonetizationOn,
        name = "My\nTransactions",
        background = GreenStart
    ),
)
@Preview(showBackground = true)
@Composable
fun FinanceSectionPreview(){
    BankingAppTheme {
        FinanceSection()
    }
}
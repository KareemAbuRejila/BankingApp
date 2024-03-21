package com.training.jetpack.bankingapp.presentation.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.training.jetpack.bankingapp.presentation.home.sections.WalletSection
import com.training.jetpack.bankingapp.presentation.home.sections.CardsSection
import com.training.jetpack.bankingapp.presentation.home.sections.CurrencySection
import com.training.jetpack.bankingapp.presentation.home.sections.FinanceSection
import com.training.jetpack.bankingapp.ui.theme.BankingAppTheme


@Composable
fun HomeScreen(onAccountClicked : ()->Unit) {
    Column {
        WalletSection(onAccountClicked)
        CardsSection()
        Spacer(modifier = Modifier.height(16.dp))
        FinanceSection()
        CurrencySection()
    }
}

@Preview(showBackground = false)
@Preview(showBackground = false, uiMode = Configuration.UI_MODE_NIGHT_YES)@Composable
fun HomeScreenPreview(){
    BankingAppTheme {
        HomeScreen {}
    }
}
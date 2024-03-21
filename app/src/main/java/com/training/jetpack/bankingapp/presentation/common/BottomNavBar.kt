package com.training.jetpack.bankingapp.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.training.jetpack.bankingapp.presentation.Dimens
import com.training.jetpack.bankingapp.presentation.Dimens.ExtraSmallPadding2
import com.training.jetpack.bankingapp.presentation.Dimens.IconSize
import com.training.jetpack.bankingapp.presentation.nav_graph.NavigationItem
import com.training.jetpack.bankingapp.ui.theme.BankingAppTheme

@Composable
fun BottomNavBar(
    navController: NavController, items: List<NavigationItem>, onItemClicked: (Int) -> Unit
) {
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            items.forEachIndexed { index, item ->
                val isSelected = selectedItemIndex == index
                this@Row.NavigationBarItem(selected = isSelected,
                    alwaysShowLabel = true,
                    onClick = {
                        selectedItemIndex = index
                        navController.navigate(item.route)
                              },
                    icon = {
                            Icon(
                                modifier = Modifier.height(Dimens.IconSize),
                                imageVector = item.icon,
                                contentDescription = "NvBarItemIcon, ${item.label}",
                                tint = if (isSelected) MaterialTheme.colorScheme.primary
                                else MaterialTheme.colorScheme.secondary
                            )
                    },
                    label = {
                        Text(
                            text = item.label, style = MaterialTheme.typography.labelSmall,
                            color = if (isSelected) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.secondary
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = MaterialTheme.colorScheme.background
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun BottomNavBarPreview() {
    val navController = rememberNavController()
    BankingAppTheme(dynamicColor = false) {
        BottomNavBar(
            navController = navController,
            items = navBarList
        ) {}
    }
}


val navBarList = listOf(
    NavigationItem.Home,
    NavigationItem.Wallet,
    NavigationItem.Notifications,
    NavigationItem.Account,
)
package com.training.jetpack.bankingapp.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.training.jetpack.bankingapp.presentation.common.BottomNavBar
import com.training.jetpack.bankingapp.presentation.common.navBarList
import com.training.jetpack.bankingapp.presentation.home.HomeScreen
import com.training.jetpack.bankingapp.presentation.nav_graph.NavigationItem
import com.training.jetpack.bankingapp.presentation.nav_graph.Route
import com.training.jetpack.bankingapp.ui.theme.BankingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            BankingAppTheme(dynamicColor = false) {
                // A surface container using the 'background' color from the theme
                SetBarColor(color = MaterialTheme.colorScheme.background)
                Scaffold(
                    bottomBar = { BottomNavBar(navController = navController, navBarList) {} }
                ) {
                    NavHost(navController = navController, startDestination = Route.Home.route, modifier = Modifier.fillMaxSize().padding(it) ){
                        composable(route = Route.Home.route){
                            HomeScreen(
                                onAccountClicked = {
                                    navController.navigate(route = Route.Account.route)
                                }
                            )
                        }
                        composable(route = Route.Wallet.route){
                            Text(text = NavigationItem.Wallet.label)
                        }
                        composable(route = Route.Notifications.route){
                            Text(text = NavigationItem.Notifications.label)
                        }
                        composable(route = Route.Account.route){
                            Text(text = NavigationItem.Account.label)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SetBarColor(color: Color) {
    val systemUiController = rememberSystemUiController()
    val isSystemInDarkMode = isSystemInDarkTheme()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = color,
            darkIcons = !isSystemInDarkMode
        )
    }
}
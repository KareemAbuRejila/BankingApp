package com.training.jetpack.bankingapp.presentation.nav_graph

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Route(
    val route: String
) {

    data object Home : Route(route = "Home")
    data object Wallet : Route(route = "Wallet")
    data object Notifications : Route(route = "Notifications")
    data object Account : Route(route = "Account")
}

sealed class NavigationItem(
    val route: String,
    val icon: ImageVector,
    val label: String,
    var indicator: Int? = 0
) {
    data object Home : NavigationItem(
        route = Route.Home.route,
        icon = Icons.Rounded.Home,
        label = "Home"
    )

    data object Wallet : NavigationItem(
        route = Route.Wallet.route,
        icon = Icons.Rounded.Wallet,
        label = "Wallet"
    )

    data object Notifications : NavigationItem(
        route = Route.Notifications.route,
        icon = Icons.Rounded.Notifications,
        label = "Notifications",
        indicator = 5
    )

    data object Account : NavigationItem(
        route = Route.Account.route,
        icon = Icons.Rounded.AccountCircle,
        label = "Account"
    )
}
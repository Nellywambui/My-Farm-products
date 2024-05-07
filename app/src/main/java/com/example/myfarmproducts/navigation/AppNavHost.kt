package com.example.myfarmproducts.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginregistration.FruitsList
import com.example.myfarmproducts.ui.theme.gallery.AddFruitsScreen
import com.example.myfarmproducts.ui.theme.about.AboutScreen
import com.example.myfarmproducts.ui.theme.delivery.deliveryScreen
import com.example.myfarmproducts.ui.theme.gallery.ViewFruitsScreen
import com.example.myfarmproducts.ui.theme.home.Background
import com.example.myfarmproducts.ui.theme.last.LastScreen
import com.example.myfarmproducts.ui.theme.login.LoginScreen
import com.example.myfarmproducts.ui.theme.register.RegisterBackground


@Composable
fun AppNavHost(modifier: Modifier = Modifier,
               navController: NavHostController = rememberNavController(),
               startDestination: String = ROUTE_HOME
) {
    NavHost(
        navController = navController,
        modifier = Modifier,
        startDestination = startDestination
    ) {
        composable(ROUTE_HOME) {
            Background(navController)
        }
        composable(ROUTE_REGISTER) {
            RegisterBackground(navController)
        }
        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }
        composable("$ROUTE_ABOUT/{userid}") { passedData->
            AboutScreen(navController, passedData.arguments?.getString("userid")!!)
        }
        composable("$ROUTE_GALLERY/{userid}") {passedData ->
            FruitsList(navController, passedData.arguments?.getString("userid")!!)
        }
        composable(ROUTE_ADD_FRUITS) {
            AddFruitsScreen(navController)
        }
        composable(ROUTE_VIEW_FRUITS) {
            ViewFruitsScreen(navController)
        }
        composable("$ROUTE_DELIVERY/{userid}") {passedData ->
            deliveryScreen(navController, passedData.arguments?.getString("userid")!!)

        }
        composable(ROUTE_LAST) {
            LastScreen(navController)
        }
    }
}
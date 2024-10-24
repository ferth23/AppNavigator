package com.example.appnavigator.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appnavigator.views.DogYearCalculatorView
import com.example.appnavigator.views.LotteryView
import com.example.appnavigator.views.PriceDiscountView

@Composable
fun NavManager() {
    val navController = rememberNavController()

    NavHost ( navController = navController, startDestination = "DogYearsCalculator" ) {
        composable ( route = "DogYearsCalculator" ) {
            DogYearCalculatorView ( navController )
        }
        composable ( route = "PriceDiscount" ) {
            PriceDiscountView ( navController )
        }
        composable ( route = "Lottery" ) {
            LotteryView ( navController )
        }
    }
}
package com.example.composenavigationapp.ui.navigation

import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation
import androidx.navigation.compose.composable
import com.example.composenavigationapp.ui.screens.PlaceholderHomeScreen
import com.example.composenavigationapp.ui.screens.SplashScreen

@Composable
fun RootNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH
    ) {
        // Splash tetap sama
        composable(Routes.SPLASH) {
            SplashScreen(onFinished = {
                navController.navigate(Routes.MAIN_GRAPH) {
                    popUpTo(Routes.SPLASH) { inclusive = true }
                    launchSingleTop = true
                }
            })
        }
        // Ganti: sebelumnya 'navigation(route = MAIN_GRAPH) { ... }'
        // Sekarang: satu composable yang menampilkan MainScaffold
        composable(Routes.MAIN_GRAPH) {
            MainScaffold() // kita buat di langkah 3.2
        }
    }
}
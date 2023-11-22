package agility.tungphan.poc.mylibrary

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavigation(onResult: (String) -> Unit) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "screen1") {
        composable("screen1") { Screen1(navController) }
        composable("screen2") { Screen2(navController) }
        composable("screen3") { Screen3(navController) }
        composable("screen4/{data}", arguments = listOf(navArgument("data") { type = NavType.StringType })) { backStackEntry ->
            Screen4(navController, backStackEntry.arguments?.getString("data") ?: "", onResult)
        }
    }
}

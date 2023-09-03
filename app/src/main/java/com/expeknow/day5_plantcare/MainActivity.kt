package com.expeknow.day5_plantcare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.expeknow.day5_plantcare.ui.theme.Day5_plantCareTheme

//https://dribbble.com/shots/9241415-Plant-care/attachments/1285148?mode=media


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Day5_plantCareTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
//                    HomeWindow(rememberNavController())
//                    val navController = rememberNavController()
//                    DetailsWindow(navController = navController, id = 3)
////                    NavHost(navController = navController, startDestination = "home"){
////                        graph(navController)
//                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Day5_plantCareTheme {
        Greeting("Android")
    }
}
package com.pranavpandey.wheatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import com.pranavpandey.wheatherapp.ui.theme.WheatherAppTheme
import com.pranavpandey.wheatherapp.view.WeatherPage
import com.pranavpandey.wheatherapp.viewModel.WeatherViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val weatherViewModel = ViewModelProvider(this)[WeatherViewModel::class.java]
            WheatherAppTheme {

                Surface(
                    modifier = Modifier.fillMaxSize().verticalScroll(enabled = true, state = rememberScrollState()),
                    color = MaterialTheme.colorScheme.background,
                    contentColor = Color.Blue,


                ){
                    WeatherPage(weatherViewModel)
                }

                }
            }
        }
    }


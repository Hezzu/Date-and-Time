package com.Hezz.loginform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.Hezz.loginform.ui.theme.LogInFormTheme
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.*
import kotlin.time.Duration.Companion.seconds

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LogInFormTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    cad()
                }
            }
        }
    }
}

@Composable
fun cad() {
    var dateFor = SimpleDateFormat("'Time: 'HH:mm:ss'\nTimezone: 'z'\nDate: 'MM-dd-yyyy")
    var tick by remember { mutableStateOf(0) }
    var date = dateFor.format(Date())
    LaunchedEffect(true){
        while (true){
            delay(1.seconds)
            tick++
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primary)
        , verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = date, color = MaterialTheme.colorScheme.onPrimary)
        Text(text = tick.toString(), color = MaterialTheme.colorScheme.primary)

    }
}
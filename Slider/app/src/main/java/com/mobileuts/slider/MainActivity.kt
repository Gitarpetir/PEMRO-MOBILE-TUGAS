package com.mobileuts.slider

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    GrowtopiaSlider()
                }
            }
        }
    }
}

@Composable
fun GrowtopiaSlider() {
    var umur by remember { mutableFloatStateOf(0f) }
    val umurBulat = umur.roundToInt()
    val teksUmur = if (umurBulat >= 25) "25+" else umurBulat.toString()
    val warnaBackground = Color(0xFF1E4C60)
    val warnaTeks = Color.White

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(warnaBackground)
            .padding(horizontal = 32.dp, vertical = 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Set your age: $teksUmur",
            color = warnaTeks,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold

        )

        Spacer(modifier = Modifier.height(64.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "0", color = warnaTeks, fontWeight = FontWeight.Bold)
            Text(text = "Age", color = warnaTeks, fontWeight = FontWeight.Bold)
            Text(text = "25+", color = warnaTeks, fontWeight = FontWeight.Bold)
        }

        Slider(
            value = umur,
            onValueChange = { umur = it },
            valueRange = 0f..25f,
            modifier = Modifier.fillMaxWidth(),
            colors = SliderDefaults.colors(
                thumbColor = Color(0xFF81D4FA),
                activeTrackColor = warnaTeks,
                inactiveTrackColor = warnaTeks
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSlider() {
    GrowtopiaSlider()
}
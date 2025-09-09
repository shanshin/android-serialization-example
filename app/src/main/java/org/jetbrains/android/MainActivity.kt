package org.jetbrains.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import bug.SyncEntity
import kotlinx.serialization.json.Json
import org.jetbrains.android.ui.theme.AndroidtestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidtestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val format = Json {
                        encodeDefaults = true
                        ignoreUnknownKeys = true
                    }

                    val json = """{"entity":"category","id":737,"type":"ATYPE"}"""
                    val result = format.decodeFromString<SyncEntity>(json)
                    Text(
                        text = "Decoded=$result",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

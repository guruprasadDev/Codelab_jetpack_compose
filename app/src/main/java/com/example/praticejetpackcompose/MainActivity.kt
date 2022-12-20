package com.example.praticejetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.praticejetpackcompose.ui.theme.PraticeJetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PraticeJetPackComposeTheme {
                setContent {
                    MyApp()
                }
            }
        }
    }
}
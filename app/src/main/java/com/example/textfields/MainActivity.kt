@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.textfields

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.textfields.ui.theme.TextFieldsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFieldsTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    TextFields()
                }
            }
        }
    }
}

@Composable
fun TextFields() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextFieldWithCharCount()
        Spacer(modifier = Modifier.height(16.dp))

        EmailTextField()
        Spacer(modifier = Modifier.height(16.dp))

        Password()

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TextFieldsTheme {
        TextFields()
    }
}
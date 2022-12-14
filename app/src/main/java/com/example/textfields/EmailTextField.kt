package com.example.textfields

import android.util.Log
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailTextField() {
    var text by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = text,
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Characters,
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                Log.d("This", "Done messeging")
            }
        ),
        label = {
            Text(text = "Email")
        },
        onValueChange = { newText ->
            text = newText
        },
        trailingIcon = {
            if (text.isNotEmpty()) IconButton(
                modifier = Modifier.alpha(0.5f),
                onClick = {
                    text = ""
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Erase the field",
                    tint = MaterialTheme.colorScheme.primary
                )
            } else {

            }
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Insert your emailo",
                modifier = Modifier.alpha(0.9f),
                tint = MaterialTheme.colorScheme.primary
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.surface,
            textColor = MaterialTheme.colorScheme.primary
        ),
        singleLine = true
    )
}


@Preview(showBackground = true)
@Composable
fun EmailPrev() {
    EmailTextField()
}

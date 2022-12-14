package com.example.textfields

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithCharCount() {
    var input by rememberSaveable {
        mutableStateOf("")
    }
    var charCount by rememberSaveable {
        mutableStateOf(input.length)
    }

    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            colors = TextFieldDefaults.textFieldColors(
                containerColor = MaterialTheme.colorScheme.surface,
                textColor = MaterialTheme.colorScheme.primary
            ),
            label = {
                Text(text = "Name")
            },
            value = input,
            onValueChange = {
                input = it
                charCount = input.length
            },
            leadingIcon = {
                Icon(
                    modifier = Modifier.alpha(0.8f),
                    tint = MaterialTheme.colorScheme.primary,
                    imageVector = Icons.Default.Person,
                    contentDescription = "Name",
                )
            },
            singleLine = true,
            trailingIcon = {
                if (input.isNotEmpty()) {
                    IconButton(
                        modifier = Modifier.alpha(0.5f),
                        onClick = {
                            charCount = 0
                            input = ""
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Erase the field",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                } else {

                }
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        )

        Text(
            modifier = Modifier
                .align(Alignment.End)
                .alpha(0.5f),
            text = charCount.toString(),
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )

    }

}


@Preview(showBackground = true)
@Composable
fun CharacterCountPrev() {
    TextFieldWithCharCount()
}
package com.example.textfields

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview



@OptIn(ExperimentalMaterial3Api::class)

//Password Text Field
@Composable
fun Password() {
    var password by rememberSaveable {
        mutableStateOf("")
    }
    var passwordVisible by rememberSaveable {
        mutableStateOf(false)
    }
    var passEndIcon = if (passwordVisible) {
        ImageVector.vectorResource(id = R.drawable.password_shown)
    } else {
        ImageVector.vectorResource(id = R.drawable.password_hidden)
    }
    OutlinedTextField(
        label = {
            Text("Password")
        },
        placeholder = {
            Text("Password")
        },
        value = password,
        onValueChange = {
            password = it
        },
        leadingIcon = {
            Icon(
                modifier = Modifier.alpha(0.9f),
                imageVector = Icons.Default.Lock,
                contentDescription = "Password",
                tint = MaterialTheme.colorScheme.primary
            )
        },
        trailingIcon = {
            IconButton(
                onClick = {
                    passwordVisible = !passwordVisible
                }
            ) {
                if (password.isNotEmpty()) {
                    Icon(
                        modifier = Modifier
                            .scale(0.8f)
                            .alpha(0.5f),
                        imageVector = passEndIcon,
                        contentDescription = "passwod visibilty toggle",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = if (passwordVisible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = MaterialTheme.colorScheme.primary
        ),
        singleLine = true
    )
}

@Preview(showBackground = true)
@Composable
fun PasswordPrev() {
    Password()
}
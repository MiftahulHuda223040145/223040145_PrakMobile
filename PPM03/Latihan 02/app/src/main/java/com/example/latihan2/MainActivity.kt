package com.example.latihan2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.latihan2.ui.theme.Latihan2Theme
import com.example.latihan2.ui.theme.Pink40
import com.example.latihan2.ui.theme.Purple80
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Latihan2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FormRegister(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

fun Greeting(username: String): String {
    return "Hello $username!"
}

@Composable
fun FormRegister(modifier: Modifier = Modifier){
    val context = LocalContext.current
    val username = remember { mutableStateOf(TextFieldValue(""))}
    val notelp = remember { mutableStateOf(TextFieldValue(""))}
    val email = remember { mutableStateOf(TextFieldValue(""))}
    val password = remember { mutableStateOf(TextFieldValue(""))}

    Column(modifier = modifier
        .fillMaxWidth()){
        Text(text = "Username", modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth())
        TextField(value = username.value, onValueChange = {
            username.value = it
        }, modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth())

        Text(text = "Nomor Telepon", modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth())
        TextField(value = notelp.value, onValueChange = {
            notelp.value = it
        }, modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth())

        Text(text = "Email", modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth())
        TextField(value = email.value, onValueChange = {
            email.value = it
        }, modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth())

        Text(text = "Password", modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth())
        TextField(value = password.value,
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = {
                password.value = it
            }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth())

        val registerButtonColors = ButtonDefaults.buttonColors(
            containerColor = Purple80,
            contentColor = Pink40
        )

        val resetButtonColors = ButtonDefaults.buttonColors(
            containerColor = Pink40,
            contentColor = Purple80
        )

        Spacer(modifier = Modifier
            .weight(1f)
            .width(0.dp))

        Row (modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()) {
            Button(modifier = Modifier.weight(5f), onClick = {
                if(username.value.text == "Mip" &&
                    notelp.value.text == "123" &&
                    email.value.text == "mip@gmail.com" &&
                    password.value.text == "123") {
                    Toast.makeText(context, Greeting(username.value.text), Toast.LENGTH_LONG).show()
                } else if(username.value.text == "" &&
                            notelp.value.text == "" &&
                            email.value.text == "" &&
                            password.value.text == "") {
                        Toast.makeText(context, "Semua Inputan Harus diisi", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, "register Gagal", Toast.LENGTH_LONG).show()
                }
            }, colors = registerButtonColors) {
                Text(
                    text = "Register",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }

            Button(modifier = Modifier.weight(5f), onClick = {
                username.value = TextFieldValue("")
                notelp.value = TextFieldValue("")
                email.value = TextFieldValue("")
                password.value = TextFieldValue("")
            }, colors = resetButtonColors) {
                Text(
                    text = "Reset",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview(){
    Latihan2Theme {
        FormRegister()
    }
}
package com.example.rickmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.rickmorty.data.model.Character

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var mostrarHome by remember {
                mutableStateOf(false)
            }

            var mostrarPersonajes by remember {
                mutableStateOf(false)
            }

            var personajeSeleccionado by remember {
                mutableStateOf<Character?>(null)
            }

            when {

                personajeSeleccionado != null -> {

                    CharacterDetailScreen(
                        personaje = personajeSeleccionado!!,
                        onBackClick = {
                            personajeSeleccionado = null
                        }
                    )
                }

                mostrarPersonajes -> {

                    CharactersScreen(
                        onCharacterClick = { personaje ->

                            personajeSeleccionado = personaje
                        }
                    )
                }

                mostrarHome -> {

                    HomeScreen(
                        onPersonajesClick = {

                            mostrarPersonajes = true
                        }
                    )
                }

                else -> {

                    LoginScreen(
                        onLoginSuccess = {

                            mostrarHome = true
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit
) {

    var usuario by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var error by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF101820))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "RICK & MORTY",
            color = Color(0xFF5AC85A)
        )

        Text(
            text = "EXPLORER",
            color = Color.White
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        OutlinedTextField(
            value = usuario,
            onValueChange = {
                usuario = it
            },
            label = {
                Text("Usuario")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text("Contraseña")
            },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Button(
            onClick = {

                if (
                    usuario.isBlank() ||
                    password.isBlank()
                ) {

                    error = "Completa todos los campos."

                } else {

                    error = ""

                    onLoginSuccess()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "INGRESAR"
            )
        }

        if (error.isNotEmpty()) {

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = error,
                color = Color.Red
            )
        }
    }
}
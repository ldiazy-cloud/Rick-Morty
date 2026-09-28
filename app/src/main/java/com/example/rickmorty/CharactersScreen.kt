package com.example.rickmorty

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.rickmorty.data.model.Character
import com.example.rickmorty.data.remote.RetrofitInstance

@Composable
fun CharactersScreen(
    onCharacterClick: (Character) -> Unit
) {

    var personajes by remember {
        mutableStateOf<List<Character>>(emptyList())
    }

    var cargando by remember {
        mutableStateOf(true)
    }

    var error by remember {
        mutableStateOf("")
    }

    LaunchedEffect(Unit) {

        try {

            val respuesta = RetrofitInstance.api.getCharacters()

            personajes = respuesta.results

        } catch (e: Exception) {

            error = "Error al cargar los personajes."

        } finally {

            cargando = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF101820))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "PERSONAJES",
            color = Color(0xFF5AC85A)
        )

        when {

            cargando -> {

                CircularProgressIndicator(
                    color = Color(0xFF5AC85A)
                )
            }

            error.isNotEmpty() -> {

                Text(
                    text = error,
                    color = Color.White
                )
            }

            else -> {

                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    items(personajes) { personaje ->

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFF1B2833))
                                .clickable {
                                    onCharacterClick(personaje)
                                }
                                .padding(12.dp)
                        ) {

                            AsyncImage(
                                model = personaje.image,
                                contentDescription = "Imagen de ${personaje.name}",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp),
                                contentScale = ContentScale.Crop
                            )

                            Text(
                                text = personaje.name,
                                color = Color(0xFF5AC85A),
                                modifier = Modifier.padding(top = 10.dp)
                            )

                            Text(
                                text = "Especie: ${personaje.species}",
                                color = Color.White
                            )

                            Text(
                                text = "Estado: ${personaje.status}",
                                color = Color.LightGray
                            )
                        }
                    }
                }
            }
        }
    }
}
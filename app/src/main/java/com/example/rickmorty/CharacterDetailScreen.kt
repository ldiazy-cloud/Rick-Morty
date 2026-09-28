package com.example.rickmorty

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.rickmorty.data.model.Character

@Composable
fun CharacterDetailScreen(
    personaje: Character,
    onBackClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF101820))
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text = "DETALLE DEL PERSONAJE",
            color = Color(0xFF5AC85A)
        )

        AsyncImage(
            model = personaje.image,
            contentDescription = "Imagen de ${personaje.name}",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop
        )

        Text(
            text = personaje.name,
            color = Color(0xFF5AC85A)
        )

        Text(
            text = "Estado: ${personaje.status}",
            color = Color.White
        )

        Text(
            text = "Especie: ${personaje.species}",
            color = Color.White
        )

        Text(
            text = "Tipo: ${
                if (personaje.type.isBlank()) "No especificado"
                else personaje.type
            }",
            color = Color.White
        )

        Text(
            text = "Género: ${personaje.gender}",
            color = Color.White
        )

        Button(
            onClick = onBackClick
        ) {
            Text(
                text = "← VOLVER"
            )
        }
    }
}


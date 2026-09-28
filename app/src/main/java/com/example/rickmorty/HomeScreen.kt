package com.example.rickmorty

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    onPersonajesClick: () -> Unit
) {

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
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF5AC85A)
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "EXPLORER",
            fontSize = 20.sp,
            color = Color.White
        )

        Spacer(
            modifier = Modifier.height(40.dp)
        )

        Text(
            text = "Bienvenido",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Text(
            text = "Explora el universo de Rick & Morty",
            fontSize = 16.sp,
            color = Color.LightGray,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(35.dp)
        )

        Button(
            onClick = onPersonajesClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF5AC85A)
            )
        ) {

            Text(
                text = "PERSONAJES",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Button(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF5AC85A)
            )
        ) {

            Text(
                text = "UBICACIONES",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Button(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF5AC85A)
            )
        ) {

            Text(
                text = "EPISODIOS",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        Text(
            text = "API: Rick and Morty",
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}
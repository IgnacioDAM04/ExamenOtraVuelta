package com.example.examen2.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.examen2.Message
import com.example.examen2.R
import com.example.examen2.data.MessageData

@Composable
fun mensage(msg: Message, coloreh: Color) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.profesor),
            contentDescription = "Icono de perfil",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary)
        )

        var isExpanded by remember { mutableStateOf(false) }

        val surfaceColor by animateColorAsState(
            if (isExpanded) coloreh else MaterialTheme.colorScheme.surface,
        )
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )

            SpaceV()

            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 1.dp,
                color = surfaceColor,
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.bodyMedium,

                    )
            }
        }
    }
}

@Composable
fun boton() {
    val listaColores = listOf(Color.Green, Color.Blue, Color.Red, Color.Cyan)

    var color by remember { mutableStateOf(Color.Magenta) }
    Row(
        Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        Button(
            onClick = {
                val random = (0..3).random()
                val colorele = listaColores[random]
                color = colorele
                      }, colors = ButtonDefaults.buttonColors(color),
            modifier = Modifier.align(alignment = Alignment.CenterVertically)
        ) {
            Text(text = "Elegir un nuevo color")

        }
    }
    testo(color = color)
}

@Composable
fun Cajetilla() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
            .border(1.5.dp, MaterialTheme.colorScheme.primary)
    ) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(R.drawable.avatar4),
                contentDescription = "Icono de perfil",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colorScheme.primary)
            )

            SpaceH()

            Column {
                Text(text = "Alumno Ignacio")
                Text(text = "Soy un alumno")
            }
        }
    }
}

@Composable
fun testo(color: Color) {
    LazyColumn {
        items(MessageData.conversationSample) { message ->
            mensage(message, color)
        }
    }

}

@Composable
fun SpaceV(Size: Dp = 5.dp) {
    Spacer(modifier = Modifier.height(Size))
}

@Composable
fun SpaceH(Size: Dp = 5.dp) {
    Spacer(modifier = Modifier.width(Size))
}
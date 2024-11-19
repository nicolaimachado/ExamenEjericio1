package com.NicolaiSchirmer.examenEj1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.NicolaiSchirmer.examenEj1.ui.theme.ExamenEjericio1Theme
import com.android.volley.toolbox.ImageRequest

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExamenEjericio1Theme {
                Ejercicio1()
            }
        }
    }
}

@Composable
fun Ejercicio1() {
    var listaVideoJuegos = listOf(
        Videojuego("Videojuego 1", 11.99, "https://loremflickr.com/400/400/seville?lock=1"),
        Videojuego("Videojuego 2", 19.99, "https://loremflickr.com/400/400/seville?lock=2"),
        Videojuego("Videojuego 3", 9.99, "https://loremflickr.com/400/400/seville?lock=3"),
        Videojuego("Videojuego 4", 14.99, "https://loremflickr.com/400/400/seville?lock=4"),
        Videojuego("Videojuego 5", 17.99, "https://loremflickr.com/400/400/seville?lock=5")
    )

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 100.dp)
    ) {
        items(listaVideoJuegos) {  vj ->
            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ){

                AsyncImage(
                    model = vj.imageURL,
                    contentDescription = "Imagen de ${vj.name}",
                    modifier = Modifier.size(133.dp)
                )
                Text(vj.name)
                Text(vj.price.toString())
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExamenEjericio1Theme {
        Greeting("Android")
    }
}

package edu.ucam.mangateka

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color

@Composable
fun HomeScreen() {

    var busqueda by remember { mutableStateOf("") }
    var seccion by remember { mutableStateOf("Inicio") }

    val mangas = listOf(
        "One Piece",
        "Naruto",
        "Attack on Titan",
        "Death Note",
        "Dragon Ball"
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                listOf("Inicio", "Explorar", "Favoritos").forEach { item ->
                    NavigationBarItem(
                        selected = seccion == item,
                        onClick = { seccion = item },
                        icon = { Text("●") },
                        label = { Text(item) }
                    )
                }
            }
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            item {
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Mangateka",
                    style = MaterialTheme.typography.headlineLarge
                )
            }

            item {
                Text(
                    text = "Descubre tu próximo manga favorito",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            item {
                OutlinedTextField(
                    value = busqueda,
                    onValueChange = { busqueda = it },
                    label = { Text("Buscar mangas") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(
                            text = "¡Bienvenido a Mangateka!",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text("Explora mangas y descubre nuevas historias.")
                    }
                }
            }

            item {
                Text(
                    text = "Mangas populares",
                    style = MaterialTheme.typography.titleLarge
                )
            }

            items(
                mangas.filter {
                    it.contains(busqueda, ignoreCase = true)
                }
            ) { manga ->

                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = manga,
                            style = MaterialTheme.typography.titleMedium
                        )

                        
                    }
                }
            }
        }
    }
}

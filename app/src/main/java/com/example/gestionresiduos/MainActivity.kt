package com.example.gestionresiduos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gestionresiduos.ui.theme.GestionResiduosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GestionResiduosTheme {
                // Controlador de navegación
                val navController = rememberNavController()

                // Pantalla principal con navegación
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Navigation(navController = navController)
                }
            }
        }
    }
}

// Función para definir la navegación
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        // Pantalla principal
        composable("home") {
            MainScreen(navController = navController)
        }
        // Pantalla de calendario
        composable("calendar") {
            CalendarScreen()
        }
        // Pantalla de mapa
        composable("map") {
            MapScreen()
        }
        // Pantalla de estadísticas
        composable("statistics") {
            StatisticsScreen()
        }
    }
}

// Pantalla principal con botones de navegación
@Composable
fun MainScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "¡Hola, Usuario! Bienvenido a GestionResiduos")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate("calendar")
        }) {
            Text(text = "Calendario de recolección")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate("map")
        }) {
            Text(text = "Mapa de puntos de reciclaje")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate("statistics")
        }) {
            Text(text = "Estadísticas personales de residuos")
        }
    }
}

// Pantalla de calendario
@Composable
fun CalendarScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Pantalla de Calendario")
    }
}

// Pantalla de mapa
@Composable
fun MapScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Pantalla de Mapa")
    }
}

// Pantalla de estadísticas
@Composable
fun StatisticsScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Pantalla de Estadísticas")
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    GestionResiduosTheme {
        val navController = rememberNavController()
        MainScreen(navController)
    }
}

package com.example.gestionresiduos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.geometry.Offset
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gestionresiduos.ui.theme.GestionResiduosTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // Instalar el splash screen
        val splashScreen = installSplashScreen()

        // Si necesitas hacer alguna inicialización pesada puedes configurar esto:
        splashScreen.setKeepOnScreenCondition {
            // De momento no tenemos tareas pesadas, por lo que lo dejamos en false
            false
        }

        super.onCreate(savedInstanceState)

        setContent {
            GestionResiduosTheme {
                // Controlador de navegación
                val navController = rememberNavController()

                // Navegación entre pantallas
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Navigation(navController = navController)
                }
            }
        }
    }
}

// Definir las pantallas y la navegación
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            MainScreen(navController = navController)
        }
        composable("calendar") {
            CalendarScreen()  // Pantalla del calendario
        }
        composable("map") {
            MapScreenWithPoints()  // Pantalla del mapa de puntos de reciclaje
        }
        composable("statistics") {
            StatisticsScreen()  // Pantalla de estadísticas
        }
    }
}

// Pantalla principal con los tres botones de navegación
@Composable
fun MainScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Botón para navegar al calendario
        Button(onClick = {
            navController.navigate("calendar")
        }) {
            Text(text = "Ver Calendario de Recolección")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para navegar al mapa de puntos de reciclaje
        Button(onClick = {
            navController.navigate("map")
        }) {
            Text(text = "Ver Mapa de Puntos de Reciclaje")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para navegar a las estadísticas
        Button(onClick = {
            navController.navigate("statistics")
        }) {
            Text(text = "Ver Estadísticas Personales de Residuos")
        }
    }
}

// Pantalla del calendario
@Composable
fun CalendarScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Pantalla de Calendario")
    }
}

// Pantalla del mapa con los puntos superpuestos
@Composable
fun MapScreenWithPoints() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val image: Painter = painterResource(id = R.drawable.map_image)
        Image(
            painter = image,
            contentDescription = "Mapa de Puntos de Reciclaje",
            contentScale = ContentScale.Crop,  // Asegura que la imagen se escale correctamente
            modifier = Modifier.fillMaxSize()
        )

        // Dibujar los puntos de recogida sobre la imagen
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawRedPoint(Offset(200f, 900f))  // Ajusta los puntos según el mapa
            drawRedPoint(Offset(1000f, 1000f))
            drawRedPoint(Offset(700f, 300f))
            drawRedPoint(Offset(700f, 1500f))
            drawRedPoint(Offset(300f, 1700f))


        }
    }
}

// Pantalla de estadísticas
@Composable
fun StatisticsScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Pantalla de Estadísticas")
    }
}

// Función para dibujar un punto rojo
fun DrawScope.drawRedPoint(offset: Offset) {
    drawCircle(
        color = Color.Red,
        radius = 20f,  // Tamaño del punto
        center = offset
    )
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    val navController = rememberNavController()
    GestionResiduosTheme {
        MainScreen(navController = navController)
    }
}

package com.example.juegopreguntasrespuestaskotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @problemDescription Desarrollar  un juego de preguntas y respuestas en el que los usuarios puedan
 * responder una serie de preguntas y obtener retroalimentación sobre sus respuestas. El juego
 * consta de tres partes principales: la bienvenida al juego, la visualización de las preguntas y
 * la visualización de las respuestas.
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 08/05/24
 * @lastModification 09/05/24
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
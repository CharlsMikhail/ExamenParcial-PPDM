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
 * @lastModification 11/05/24
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Esta ACTIVIDAD es quien ALBERGA a todas los FRAGMENTOS:
        // 0. WelcomeFragmet -> Se muestra una pequela bienvenida a el usuario apr que sepa de que
        //    trata el Juego, junto a detalle y mejor tiempo y puntuacion del juego.
        // 1. QuestionFragment -> Es por donde comienza al inicializar al app y donde se muestra la
        //    primera pregunta con sus respectivas alternativas.
        // 2. AnswerFragment -> Se muestra retroalimentacion al usuario sobre su respuesta en
        //    QuestionFragment.
        // 3. ScoreFragment -> Se muestra cuando ya no hya mas pregunta y se da a concer el puntaje
        //     y el tiempo demorado en todas las preguntas.
    }
}
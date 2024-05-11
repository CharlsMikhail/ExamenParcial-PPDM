package com.example.juegopreguntasrespuestaskotlin
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController

const val KEY_TOP_SCORE = "topScore"
const val KEY_TOP_TIME = "topTime"

// Inicializaremos los que guardaran el tiempo del inicio y final y con ello hallar cuando demoro.
var startTime = 0.0
var endTime = 0.0

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnJugar = view.findViewById<Button>(R.id.btn_play)

        actualizarTopScoreAndTime(view)

        //Nos dirigimos a el siguiente fragmento: La pantalla de la pregunta.
        btnJugar.setOnClickListener {
            // Capturamos el tiempo de inicio.
            startTime = System.currentTimeMillis() / 1000.0

            view.findNavController().navigate(R.id.action_welcomeFragment_to_questionFragment)
        }
    }

    private fun actualizarTopScoreAndTime(view: View) {
        val textTopScore = view.findViewById<TextView>(R.id.txt_top_score)
        val textTopTime = view.findViewById<TextView>(R.id.txt_top_time)

        val sharedPrefs = requireActivity().getSharedPreferences("MiAppPrefs", Context.MODE_PRIVATE)

        // Actualizamos la mejor puntuación.
        val mejorPuntuacion = sharedPrefs.getInt(KEY_TOP_SCORE, 0)
        val topScore = resources.getString(R.string.txt_top_score, mejorPuntuacion)
        textTopScore.text = topScore

        // Actualizamos el mejor tiempo.
        val mejorTiempo = sharedPrefs.getFloat(KEY_TOP_TIME, 0F)
        val formattedTime = String.format("%.2f", mejorTiempo)
        val topTime = resources.getString(R.string.txt_top_time, formattedTime)
        textTopTime.text = topTime
    }
}
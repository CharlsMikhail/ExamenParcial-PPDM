package com.example.juegopreguntasrespuestaskotlin

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.findNavController

class ScoreFragment : Fragment(R.layout.fragment_score) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtPuntuacion = view.findViewById<TextView>(R.id.score)
        val btnInicio = view.findViewById<Button>(R.id.btn_inicio)
        var puntuacion = 0

        // Recuperamos la informacion enviada por AnswerFragment()
        arguments?.let { bundle ->
            puntuacion = bundle.getInt(KEY_SCORE)
        }
        txtPuntuacion.text = puntuacion.toString()

        btnInicio.setOnClickListener {
            // Actualizamos la mejor puntuación y el mejor tiempo; volvemos a WelcomeFragment()
            actualizarMejorTiempoYPuntaje(puntuacion)
            findNavController().popBackStack(R.id.welcomeFragment, false)
        }
    }

    private fun actualizarMejorTiempoYPuntaje(puntuacion: Int) {
        val sharedPrefs = requireActivity().getSharedPreferences("MiAppPrefs", Context.MODE_PRIVATE)
        // Mejor puntuación
        val mejorPuntuacionActual = sharedPrefs.getInt(KEY_TOP_SCORE, 0)
        if (puntuacion > mejorPuntuacionActual) {
            with(sharedPrefs.edit()) {
                putInt(KEY_TOP_SCORE, puntuacion)
                apply()
            }
        }

        // Mejor tiempo
        val mejorTiempoActual: Float = sharedPrefs.getFloat(KEY_TOP_TIME, 0F)
        val time = (endTime - startTime).toFloat()
        if (time < mejorTiempoActual) {
            with(sharedPrefs.edit()) {
                putFloat(KEY_TOP_TIME, time)
                apply()
            }
        }
    }
}
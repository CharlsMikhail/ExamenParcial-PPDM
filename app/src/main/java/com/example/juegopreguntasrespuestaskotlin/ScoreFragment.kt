package com.example.juegopreguntasrespuestaskotlin

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

        arguments?.let { bundle ->
            puntuacion = bundle.getInt(KEY_SCORE)
        }
        txtPuntuacion.text = puntuacion.toString()

        btnInicio.setOnClickListener {
            findNavController().popBackStack(R.id.welcomeFragment, false)
        }
    }
}
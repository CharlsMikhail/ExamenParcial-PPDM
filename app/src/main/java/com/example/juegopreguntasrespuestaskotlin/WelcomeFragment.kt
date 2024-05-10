package com.example.juegopreguntasrespuestaskotlin
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController

const val KEY_TOP_SCORE = "topScore"

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnJugar = view.findViewById<Button>(R.id.btn_play)
        val textView = view.findViewById<TextView>(R.id.txt_top_score)

        // Actualizamos la mejor puntuación.
        val sharedPrefs = requireActivity().getSharedPreferences("MiAppPrefs", Context.MODE_PRIVATE)
        val mejorPuntuacion = sharedPrefs.getInt(KEY_TOP_SCORE, 0)
        val text = resources.getString(R.string.txt_top_score, mejorPuntuacion)
        textView.text = text

        //Nos dirigimos a el siguiente fragmento: La pantalla de la pregunta.
        btnJugar.setOnClickListener {
            view.findNavController().navigate(R.id.action_welcomeFragment_to_questionFragment)
        }
    }
}
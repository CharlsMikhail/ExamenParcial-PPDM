package com.example.juegopreguntasrespuestaskotlin
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.navigation.findNavController

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnJugar = view.findViewById<Button>(R.id.btn_play)

        btnJugar.setOnClickListener {
            view.findNavController().navigate(R.id.action_welcomeFragment_to_questionFragment)
        }
    }
}
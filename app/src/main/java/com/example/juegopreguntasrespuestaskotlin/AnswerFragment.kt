package com.example.juegopreguntasrespuestaskotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController

class AnswerFragment : Fragment(R.layout.fragment_answer) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnContinuar = view.findViewById<Button>(R.id.btn_continuar)
        var numQuestion = 1
        var benedicto = false
        var puntuacion = 0

        arguments?.let { bundle ->
            numQuestion = bundle.getInt(KEY_NUM_QUESTION)
            benedicto = bundle.getBoolean(KEY_BENEDICT)
            puntuacion = bundle.getInt(KEY_SCORE)
        }

        actualizarInterfaz(view, numQuestion, benedicto)

        btnContinuar.setOnClickListener {
            if (numQuestion < 8) {
                view.findNavController().popBackStack()
                view.findNavController().popBackStack()
                view.findNavController().navigate(R.id.questionFragment)
            } else {
                // Capturamos el tiempo de fin.
                endTime = System.currentTimeMillis() / 1000.0

                //val formattedTime = String.format("%.2f", endTime - startTime)
                //Toast.makeText(context, "Demoro: $formattedTime segundos", Toast.LENGTH_LONG).show()

                val info = Bundle()
                info.putInt(KEY_SCORE, puntuacion)
                view.findNavController().navigate(R.id.action_answerFragment_to_scoreFragment, info)
            }
        }
    }

    private fun actualizarInterfaz(view: View, numQuestion: Int, benedicto: Boolean) {
        val txtRetroalimentacion = view.findViewById<TextView>(R.id.txt_respuesta_detallada)
        val imgBenedicto = view.findViewById<ImageView>(R.id.img_benedict)

        if (benedicto) {
            imgBenedicto.setBackgroundResource(R.drawable.correcto)
        } else {
            imgBenedicto.setBackgroundResource(R.drawable.incorrecto)
        }

        when (numQuestion) {
            1 -> txtRetroalimentacion.text = getString(R.string.txt_rpt_pg1)
            2 -> txtRetroalimentacion.text = getString(R.string.txt_rpt_pg2)
            3 -> txtRetroalimentacion.text = getString(R.string.txt_rpt_pg3)
            4 -> txtRetroalimentacion.text = getString(R.string.txt_rpt_pg4)
            5 -> txtRetroalimentacion.text = getString(R.string.txt_rpt_pg5)
            6 -> txtRetroalimentacion.text = getString(R.string.txt_rpt_pg6)
            7 -> txtRetroalimentacion.text = getString(R.string.txt_rpt_pg7)
            8 -> txtRetroalimentacion.text = getString(R.string.txt_rpt_pg8)
        }
    }
}
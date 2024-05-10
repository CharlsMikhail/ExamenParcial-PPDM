package com.example.juegopreguntasrespuestaskotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController

const val KEY_NUM_QUESTION = "question"
const val KEY_BENEDICT = "answer"
const val KEY_SCORE ="score"

class QuestionFragment : Fragment(R.layout.fragment_question) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (numPregunta >= 8) { puntuacion = 0; numPregunta = 0;}
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        numPregunta++
        actualizarInterfaz(view)

        val rdbOpc1 = view.findViewById<RadioButton>(R.id.rdb_pregunta_opc1)
        val rdbOpc2 = view.findViewById<RadioButton>(R.id.rdb_pregunta_opc2)
        val rdbOpc3 = view.findViewById<RadioButton>(R.id.rdb_pregunta_opc3)
        val rdbOpc4 = view.findViewById<RadioButton>(R.id.rdb_pregunta_opc4)

        val btnValidar = view.findViewById<Button>(R.id.btn_validar)

        btnValidar.setOnClickListener {
            val opcionElegida = when {
                rdbOpc1.isChecked -> 1
                rdbOpc2.isChecked -> 2
                rdbOpc3.isChecked -> 3
                rdbOpc4.isChecked -> 4
                else -> {
                    Toast.makeText(context, "Por favor, seleccione una opción", Toast.LENGTH_LONG).show()
                    return@setOnClickListener  // Salir del evento de clic sin continuar
                }
            }

            val benedicto = calcularBenedicto(opcionElegida)

            if (benedicto) puntuacion += 3 else puntuacion--

            // Preparamos la información qeu pasaremos a la pantalla de retroalimentación.
            val info = Bundle()
            info.putInt(KEY_NUM_QUESTION, numPregunta)
            info.putBoolean(KEY_BENEDICT, benedicto)
            info.putInt(KEY_SCORE, puntuacion)

            view.findNavController().navigate(R.id.action_questionFragment_to_answerFragment, info)
        }
    }

    private fun actualizarInterfaz(view: View) {

        val txtPuntuacion = view.findViewById<TextView>(R.id.txt_puntuacion)
        val txtPregunta = view.findViewById<TextView>(R.id.txt_pregunta)
        val rdbOpc1 = view.findViewById<RadioButton>(R.id.rdb_pregunta_opc1)
        val rdbOpc2 = view.findViewById<RadioButton>(R.id.rdb_pregunta_opc2)
        val rdbOpc3 = view.findViewById<RadioButton>(R.id.rdb_pregunta_opc3)
        val rdbOpc4 = view.findViewById<RadioButton>(R.id.rdb_pregunta_opc4)

        val puntuacionText = "Puntuacion: "
        txtPuntuacion.text = buildString {
            append(puntuacionText)
            append(puntuacion.toString())
        }

        when (numPregunta) {
            1 -> {
                txtPregunta.text = getString(R.string.txt_pregunta1)
                rdbOpc1.text = getString(R.string.rdb_pg1_opc1)
                rdbOpc2.text = getString(R.string.rdb_pg1_opc2)
                rdbOpc3.text = getString(R.string.rdb_pg1_opc3)
                rdbOpc4.text = getString(R.string.rdb_pg1_opc4)
            }
            2 -> {
                txtPregunta.text = getString(R.string.txt_pregunta2)
                rdbOpc1.text = getString(R.string.rdb_pg2_opc1)
                rdbOpc2.text = getString(R.string.rdb_pg2_opc2)
                rdbOpc3.text = getString(R.string.rdb_pg2_opc3)
                rdbOpc4.text = getString(R.string.rdb_pg2_opc4)
            }
            3 -> {
                txtPregunta.text = getString(R.string.txt_pregunta3)
                rdbOpc1.text = getString(R.string.rdb_pg3_opc1)
                rdbOpc2.text = getString(R.string.rdb_pg3_opc2)
                rdbOpc3.text = getString(R.string.rdb_pg3_opc3)
                rdbOpc4.text = getString(R.string.rdb_pg3_opc4)
            }
            4 -> {
                txtPregunta.text = getString(R.string.txt_pregunta4)
                rdbOpc1.text = getString(R.string.rdb_pg4_opc1)
                rdbOpc2.text = getString(R.string.rdb_pg4_opc2)
                rdbOpc3.text = getString(R.string.rdb_pg4_opc3)
                rdbOpc4.text = getString(R.string.rdb_pg4_opc4)
            }
            5 -> {
                txtPregunta.text = getString(R.string.txt_pregunta5)
                rdbOpc1.text = getString(R.string.rdb_pg5_opc1)
                rdbOpc2.text = getString(R.string.rdb_pg5_opc2)
                rdbOpc3.text = getString(R.string.rdb_pg5_opc3)
                rdbOpc4.text = getString(R.string.rdb_pg5_opc4)
            }
            6 -> {
                txtPregunta.text = getString(R.string.txt_pregunta6)
                rdbOpc1.text = getString(R.string.rdb_pg6_opc1)
                rdbOpc2.text = getString(R.string.rdb_pg6_opc2)
                rdbOpc3.text = getString(R.string.rdb_pg6_opc3)
                rdbOpc4.text = getString(R.string.rdb_pg6_opc4)
            }
            7 -> {
                txtPregunta.text = getString(R.string.txt_pregunta7)
                rdbOpc1.text = getString(R.string.rdb_pg7_opc1)
                rdbOpc2.text = getString(R.string.rdb_pg7_opc2)
                rdbOpc3.text = getString(R.string.rdb_pg7_opc3)
                rdbOpc4.text = getString(R.string.rdb_pg7_opc4)
            }
            8 -> {
                txtPregunta.text = getString(R.string.txt_pregunta8)
                rdbOpc1.text = getString(R.string.rdb_pg8_opc1)
                rdbOpc2.text = getString(R.string.rdb_pg8_opc2)
                rdbOpc3.text = getString(R.string.rdb_pg8_opc3)
                rdbOpc4.text = getString(R.string.rdb_pg8_opc4)
            }
        }
    }

    private fun calcularBenedicto(opcionElegida: Int): Boolean {
        return when (numPregunta) {
            1 -> opcionElegida == 1
            2 -> opcionElegida == 1
            3 -> opcionElegida == 2
            4 -> opcionElegida == 3
            5 -> opcionElegida == 3
            6 -> opcionElegida == 2
            7 -> opcionElegida == 1
            else -> opcionElegida == 1
        }
    }

    companion object {
        var numPregunta = 0
        var puntuacion = 0
    }

}
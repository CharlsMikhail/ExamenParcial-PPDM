package com.example.juegopreguntasrespuestaskotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.fragment.app.findFragment

class QuestionFragment : Fragment(R.layout.fragment_question) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtPuntuacion = view.findViewById<EditText>(R.id.txt_puntuacion)
        val txtPregunta = view.findViewById<EditText>(R.id.txt_pregunta)

        val rdb_opc1 = view.findViewById<RadioButton>(R.id.rdb_pregunta_opc1)
        val rdb_opc2 = view.findViewById<RadioButton>(R.id.rdb_pregunta_opc2)
        val rdb_opc3 = view.findViewById<RadioButton>(R.id.rdb_pregunta_opc3)
        val rdb_opc4 = view.findViewById<RadioButton>(R.id.rdb_pregunta_opc4)

        val btn_validar = view.findViewById<Button>(R.id.btn_validar)

        btn_validar.setOnClickListener {
            val opcion_elegida = when {
                rdb_opc1.isChecked -> 1
                rdb_opc2.isChecked -> 2
                rdb_opc3.isChecked -> 3
                else -> 4
            }
        }
    }

    fun actualizarInterfaz() {

    }

}
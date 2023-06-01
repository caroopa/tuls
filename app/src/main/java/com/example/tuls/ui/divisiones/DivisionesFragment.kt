package com.example.tuls.ui.divisiones

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.tuls.R
import com.example.tuls.backend.Comun
import com.example.tuls.backend.SegundaDivision
import com.example.tuls.backend.TerceraDivision

class DivisionesFragment : Fragment() {
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView = inflater.inflate(R.layout.fragment_divisiones, container, false)
        val eleccion = rootView.findViewById<TextView>(R.id.eleccionComunDivisiones)
        val button = rootView.findViewById<Button>(R.id.buttonDivisiones)
        val radioGroup = rootView.findViewById<RadioGroup>(R.id.radioGroup)

        button.setOnClickListener {
            val selectedOptionId = radioGroup.checkedRadioButtonId

            if (selectedOptionId == R.id.radioButtonOption1) {
                val comun = Comun(SegundaDivision)
                val tul = comun.tulQueLeToca().nombre
                eleccion.text = tul
            } else if (selectedOptionId == R.id.radioButtonOption2) {
                val comun = Comun(TerceraDivision)
                val tul = comun.tulQueLeToca().nombre
                eleccion.text = tul
            }
        }

        return rootView
    }
}
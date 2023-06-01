package com.example.tuls.ui.slideshow

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tuls.R
import com.example.tuls.backend.Azul
import com.example.tuls.backend.Options
import com.example.tuls.backend.Rojo

class SlideshowFragment : Fragment() {
    lateinit var spinner: Spinner
    val options = Options.gradosNombres

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView = inflater.inflate(R.layout.fragment_slideshow, container, false)
        spinner = rootView.findViewById<Spinner>(R.id.spinnerTorneo)
        val button = rootView.findViewById<Button>(R.id.buttonTorneo)
        val eleccion = rootView.findViewById<TextView>(R.id.eleccionComunTorneo)

        spinner()

        button.setOnClickListener {
            val valor = spinner.selectedItemPosition
            if(valor == 0) {
                Toast.makeText(context, "Seleccione una opción", Toast.LENGTH_SHORT).show()
            } else {
                val jugadorAzul = Azul(Options.grados.find { it.nombre == options[valor] }!!)
                val jugadorRojo = Rojo(Options.grados.find { it.nombre == options[valor] }!!)
                val tulAzul = jugadorAzul.tulQueLeToca(jugadorRojo).nombre
                val tulRojo = jugadorRojo.tulQueLeToca(jugadorAzul).nombre
                eleccion.text = tulRojo
            }
        }

        return rootView
    }

    private fun spinner() {
        val nonSelectablePosition = 0

        val adapter = object : ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, options) {
            override fun isEnabled(position: Int): Boolean {
                // Si es la posición del elemento no seleccionable, devolver falso
                return position != nonSelectablePosition
            }

            override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getDropDownView(position, convertView, parent)
                val textView = view as TextView
                // Si es la posición del elemento no seleccionable, establecer el color de texto en gris claro
                if (position == nonSelectablePosition) {
                    textView.setTextColor(Color.GRAY)
                }
                return view
            }
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                Toast.makeText(context, "Seleccioná algo estúpido", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
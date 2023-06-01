package com.example.tuls.ui.torneos

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tuls.CustomSpinner
import com.example.tuls.R
import com.example.tuls.backend.Azul
import com.example.tuls.backend.Options
import com.example.tuls.backend.Rojo

class TorneosFragment : Fragment() {
    lateinit var spinner: Spinner
    private val options = Options.gradosNombres

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView = inflater.inflate(R.layout.fragment_torneos, container, false)
        spinner = rootView.findViewById<Spinner>(R.id.spinnerTorneo)
        val button = rootView.findViewById<Button>(R.id.buttonTorneo)
        val eleccion = rootView.findViewById<TextView>(R.id.eleccionComunTorneo)

        CustomSpinner.definirSpinner(setOf(spinner), options, this)

        button.setOnClickListener {
            val valor = spinner.selectedItemPosition
            if (valor == 0) {
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
}
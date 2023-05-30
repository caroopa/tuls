package com.example.tuls.ui.home

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
import com.example.tuls.CustomSpinner
import com.example.tuls.R
import com.example.tuls.backend.Azul
import com.example.tuls.backend.Comun
import com.example.tuls.backend.Options
import com.example.tuls.backend.PrimeraDivision
import com.example.tuls.backend.Rojo

class HomeFragment : Fragment() {
    private lateinit var spinnerRojo: Spinner
    private lateinit var spinnerAzul: Spinner
    val options = Options.gradosNombres

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
        spinnerRojo = rootView.findViewById<Spinner>(R.id.spinnerRojo)
        spinnerAzul = rootView.findViewById<Spinner>(R.id.spinnerAzul)
        val button = rootView.findViewById<Button>(R.id.button)
        val eleccionComun = rootView.findViewById<TextView>(R.id.eleccionComun)
        val eleccionRojo = rootView.findViewById<TextView>(R.id.eleccionRojo)
        val eleccionAzul = rootView.findViewById<TextView>(R.id.eleccionAzul)

        CustomSpinner.definirSpinner(setOf(spinnerRojo, spinnerAzul), options, this)

        button.setOnClickListener {
            val valorRojo = spinnerRojo.selectedItemPosition
            val valorAzul = spinnerAzul.selectedItemPosition
            if(valorRojo == 0 || valorAzul == 0) {
                Toast.makeText(context, "Seleccione una opción", Toast.LENGTH_SHORT).show()
            } else {
                val comun = Comun(PrimeraDivision)
                val tul = comun.tulQueLeToca().nombre
                eleccionComun.text = tul

                val jugadorAzul = Azul(Options.grados.find { it.nombre == options[valorAzul] }!!)
                val jugadorRojo = Rojo(Options.grados.find { it.nombre == options[valorRojo] }!!)
                val tulAzul = jugadorAzul.tulQueLeToca(jugadorRojo).nombre
                val tulRojo = jugadorRojo.tulQueLeToca(jugadorAzul).nombre
                eleccionRojo.text = tulRojo
                eleccionAzul.text = tulAzul
            }
        }

        return rootView
    }
}
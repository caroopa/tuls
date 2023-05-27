package com.example.tuls.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.tuls.R
import com.example.tuls.backend.Options

class HomeFragment : Fragment() {

//    private var _binding: FragmentHomeBinding? = null
//
//    // This property is only valid between onCreateView and
//    // onDestroyView.
//    private val binding get() = _binding!!
    private lateinit var spinnerRojo: Spinner
    private lateinit var spinnerAzul: Spinner

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        val tituloSpinnerRojo = rootView.findViewById<TextView>(R.id.tituloSpinnerRojo)
        tituloSpinnerRojo.text = "Rojo"
        spinnerRojo = rootView.findViewById(R.id.spinnerRojo)

        val tituloSpinnerAzul = rootView.findViewById<TextView>(R.id.tituloSpinnerAzul)
        tituloSpinnerAzul.text = "Azul"
        spinnerAzul = rootView.findViewById(R.id.spinnerAzul)

        spinner()

        return rootView
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }

    fun spinner() {
        val options = Options.grados

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerAzul.adapter = adapter
        spinnerRojo.adapter = adapter

        spinnerAzul.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedOption = options[position]
                // Hacer algo con la opción seleccionada
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Acción cuando no se selecciona nada
            }
        }

        spinnerRojo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedOption = options[position]
                // Hacer algo con la opción seleccionada
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Acción cuando no se selecciona nada
            }
        }
    }
}
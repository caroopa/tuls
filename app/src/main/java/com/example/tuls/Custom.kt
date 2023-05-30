package com.example.tuls

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

object CustomSpinner {
    fun definirSpinner(spinners: Set<Spinner>, options: List<String>, fragment: Fragment) {
        val nonSelectablePosition = 0

        val adapter = object :
            ArrayAdapter<String>(fragment.requireContext(), android.R.layout.simple_spinner_item, options) {
            override fun isEnabled(position: Int): Boolean {
                return position != nonSelectablePosition
            }

            override fun getDropDownView(
                position: Int,
                convertView: View?,
                parent: ViewGroup
            ): View {
                val view = super.getDropDownView(position, convertView, parent)
                val textView = view as TextView
                if (position == nonSelectablePosition) {
                    textView.setTextColor(Color.GRAY)
                } else {
                    textView.setTextColor(Color.BLACK)
                }
                return view
            }
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        aplicarAdapter(spinners, adapter)
        aplicarAcciones(spinners, fragment)
    }

    private fun aplicarAdapter(spinners: Set<Spinner>, adapter: ArrayAdapter<String>) =
        spinners.forEach { it.adapter = adapter }

    private fun aplicarAcciones(spinners: Set<Spinner>, fragment: Fragment) {
        spinners.forEach {
            it.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(fragment.context, "Seleccione una opción", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
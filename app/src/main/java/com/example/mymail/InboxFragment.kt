package com.example.mymail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class InboxFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.inbox_fragment, container, false)

        // Configurar la toolbar para mostrar la flecha de volver
        val toolbar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_inbox)
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)

        // Mostrar la flecha "atrás" sin usar ningún vector ni drawable
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            // Volver al menú principal
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        return view
    }
}

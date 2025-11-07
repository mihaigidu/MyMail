package com.example.mymail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

class TrashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 1️⃣ Inflar la vista primero
        val view = inflater.inflate(R.layout.trash_fragment, container, false)

        // 2️⃣ Configurar la Toolbar después
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar_trash)
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)

        // 3️⃣ Mostrar la flecha de volver
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // 4️⃣ Acción al pulsar la flecha
        toolbar.setNavigationOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, InboxFragment())
                .commit()
        }

        return view
    }
}

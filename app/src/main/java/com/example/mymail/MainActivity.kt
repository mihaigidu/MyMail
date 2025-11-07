package com.example.mymail

import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        // Configurar Spinner en el header
        val headerView = navigationView.getHeaderView(0)
        val spinner: Spinner = headerView.findViewById(R.id.account_spinner)
        val accounts = listOf(
            "carladom@gmail.com",
            "alu123@ieselcaminas.org",
            "correocarla@gmail.es"
        )
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, accounts)

        // Fragment inicial
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, InboxFragment())
            .commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val fragment = when (item.itemId) {
            R.id.nav_inbox -> InboxFragment()
            R.id.nav_outbox -> OutboxFragment()
            R.id.nav_trash -> TrashFragment()
            R.id.nav_spam -> SpamFragment()
            else -> null
        }

        fragment?.let {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, it)
                .addToBackStack(null)
                .commit()
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    // Si presionas "atrás", y hay fragments apilados, retrocede
    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}

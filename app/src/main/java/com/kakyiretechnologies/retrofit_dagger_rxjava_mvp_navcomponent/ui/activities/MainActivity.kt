package com.kakyiretechnologies.retrofit_dagger_rxjava_mvp_navcomponent.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.kakyiretechnologies.retrofit_dagger_rxjava_mvp_navcomponent.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation.setupWithNavController(nav_host_fragment_container.findNavController())
    }
}
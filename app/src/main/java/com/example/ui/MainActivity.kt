package com.example.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.fragments.FragmentOne
import com.example.fragments.FragmentTwo
import com.example.fragments.R
import com.example.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        with(binding){
            buttonFragmentOne.setOnClickListener {
                goToFragment(FragmentOne())
            }
            buttonFragmentTwo.setOnClickListener {
                goToFragment(FragmentTwo())
            }
        }
    }

    private fun goToFragment(fragment: Fragment) {
        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.FragmentContainer, fragment).commit()
    }
}
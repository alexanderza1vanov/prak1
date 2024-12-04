package com.example.second_11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentOne())
                .commit()
        }

        val buttonFragmentOne: Button = findViewById(R.id.buttonFragmentOne)
        val buttonFragmentTwo: Button = findViewById(R.id.buttonFragmentTwo)
        val buttonFragmentThree: Button = findViewById(R.id.buttonFragmentThree)

        buttonFragmentOne.setOnClickListener { loadFragment(FragmentOne()) }
        buttonFragmentTwo.setOnClickListener { loadFragment(FragmentTwo()) }
        buttonFragmentThree.setOnClickListener { loadFragment(FragmentThree()) }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}

package com.example.android_testing.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_testing.R
import com.example.android_testing.ui.main.MainFragment
import com.example.android_testing.databinding.MainActivityBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MainActivityBinding.inflate(layoutInflater).root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}
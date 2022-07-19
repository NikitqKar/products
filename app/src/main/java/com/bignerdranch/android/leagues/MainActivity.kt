package com.bignerdranch.android.leagues

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bignerdranch.android.leagues.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).root)
    }
}

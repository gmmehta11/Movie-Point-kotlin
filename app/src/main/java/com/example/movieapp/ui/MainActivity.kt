package com.example.movieapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieapp.R
import com.example.movieapp.ui.movie_details.MovieDetails
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_press.setOnClickListener {
            val intent = Intent(this, MovieDetails::class.java)
            intent.putExtra("id", 8619)
            this.startActivity(intent)
        }
    }
}
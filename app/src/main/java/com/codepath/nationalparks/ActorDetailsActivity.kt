package com.codepath.nationalparks

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class ActorDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actor_details)

        // Find views by ID
        val actorName = findViewById<TextView>(R.id.actorName)
        val movieTitleText = findViewById<TextView>(R.id.movieTitleText)
        val movieOverviewText = findViewById<TextView>(R.id.movieOverviewText)
        val actorImage = findViewById<ImageView>(R.id.actorImage)
        val movieImage = findViewById<ImageView>(R.id.movieImage)


        // Get data from intent
        val name = intent.getStringExtra("name")
        val actorImageUrl = intent.getStringExtra("actorImageUrl")
        val movieTitle = intent.getStringExtra("movieTitle")
        val movieImageUrl = intent.getStringExtra("movieImageUrl")
        val movieOverview = intent.getStringExtra("movieOverview")

        // Bind to UI
        actorName.text = name
        movieTitleText.text = movieTitle
        movieOverviewText.text = movieOverview

        Glide.with(this).load(actorImageUrl).into(actorImage)
        Glide.with(this).load(movieImageUrl).into(movieImage)
    }
}
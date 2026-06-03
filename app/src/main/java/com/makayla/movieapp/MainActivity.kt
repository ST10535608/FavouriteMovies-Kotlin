package com.makayla.movieapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Declaring variables

        val edtNameTxt = findViewById<EditText>(R.id.edtTxtName)
        val exploreButton = findViewById<Button>(R.id.exploreBtn)
        val welcomeMsg = findViewById<TextView>(R.id.txtWelcomeMsg)

        // creating an array of movies

        val movies = arrayOf("Minions", "Inside Out", "Spiderman", "Boss Baby", "Toy Story")

        // button where a Welcome message is being displayed

        exploreButton.setOnClickListener {
            val movieDisplay = displayMovies(movies)
            welcomeMsg.text = "Welcome ${edtNameTxt.text}!\n\n" + movieDisplay

            // create the explicit intent to open the second screen
            val intent = Intent(this, MovieListActivity::class.java)

            // pass the movie list to the second screen
            intent.putExtra("MOVIE_LIST", movieDisplay)

            //open the second screen
            startActivity(intent)
        }
    }

    // building display string from array of movies
    fun displayMovies(movies: Array<String>): String {
        var movieList = "My favourite movies:\n"
        for (movie in movies) {
            movieList = movieList + "- " + movie + "\n"
        }
        return movieList
    }
}
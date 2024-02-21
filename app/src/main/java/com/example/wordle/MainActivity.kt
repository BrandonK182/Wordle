package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val fourword = FourLetterWordList
    var guess = ""
    var output = ""
    var guessCount = 0
    var word = fourword.getRandomFourLetterWord()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val input = findViewById<EditText>(R.id.userText)
        val tvWordle = findViewById<TextView>(R.id.textView)

        button.setOnClickListener(){
            guess = input.text.toString()
            guessCount++
            output += "\n" + "Guess #" + guessCount.toString() + ":   " + guess
            output += "\n" + "Guess #" + guessCount.toString() + ":   " + checkGuess()
            tvWordle.text = output
        }

    }

    fun checkGuess(): String {
        var i = 0
        var correct = ""
        if (guess.length == 4)
            while(i < 4){
                if(guess[i] == word[i])
                    correct += "O"
                else
                    correct += "X"
                i++
            }
        else
            correct = "NOT LENGTH of 4 CHARACTERS"
        return correct
    }


}
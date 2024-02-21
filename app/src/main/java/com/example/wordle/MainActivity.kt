package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.Locale

class MainActivity : AppCompatActivity() {
    val debug = true
    val fourword = FourLetterWordList
    var guess = ""
    var output = ""
    var guessCount = 0
    var word = fourword.getRandomFourLetterWord()
    var win = false
    var messagePrinted = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val input = findViewById<EditText>(R.id.userText)
        val tvWordle = findViewById<TextView>(R.id.textView)

        if(debug)
            output = "DEBUG THE WORD IS: " + word

        button.setOnClickListener(){
            if(!win) {
                guess = input.text.toString().uppercase()
                guessCount++
                output += "\n" + "Guess #" + guessCount.toString() + ":   " + guess
                output += "\n" + "Guess #" + guessCount.toString() + ":   " + checkGuess()
                tvWordle.text = output
                win = checkWin()
            }
            if(win && !messagePrinted) {
                output += "\n" + "congrats you won!!!"
                messagePrinted = true
                tvWordle.text = output
            }

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

    fun checkWin(): Boolean {
        var i = 0
        var winCon = true
        if (guess.length == 4)
            while(i < 4){
                if(guess[i] != word[i])
                    winCon = false
                i++
            }
        else
            winCon = false
        return winCon
    }


}
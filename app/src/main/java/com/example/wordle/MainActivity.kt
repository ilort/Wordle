package com.example.wordle

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wordle.FourLetterWordList.getRandomFourLetterWord

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val guess = findViewById<EditText>(R.id.input)
        val wordToGuess = getRandomFourLetterWord()
        val textView1 = findViewById<TextView>(R.id.row1)
        val textView2 = findViewById<TextView>(R.id.row2)
        val textView3 = findViewById<TextView>(R.id.row3)
        val textView4 = findViewById<TextView>(R.id.row4)
        val textView5 = findViewById<TextView>(R.id.row5)
        val textView6 = findViewById<TextView>(R.id.row6)
        val hiddenAnswer = findViewById<TextView>(R.id.hiddenAnswer)
        hiddenAnswer.text = wordToGuess

        fun checkGuess(guess: String): String {
            var result = ""

            for (i in 0..3) {
                if (guess[i] == wordToGuess[i]) {
                    result += "O"
                } else if (guess[i] in wordToGuess) {
                    result += "+"
                } else {
                    result += "X"
                }
            }
            return result
        }

        button.setOnClickListener {

            val view: View? = this.currentFocus

            // on below line checking if view is not null.
            if (view != null) {
                // on below line we are creating a variable
                // for input manager and initializing it.
                val inputMethodManager =
                    getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

                // on below line hiding our keyboard.
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0)
            }
                val strValue: String = guess.text.toString().uppercase()
                guess.text.clear()
                textView1.text = strValue
                textView1.visibility = View.VISIBLE
                textView2.text = checkGuess(strValue)
                textView2.visibility = View.VISIBLE
                if (textView2.text == "OOOO") {
                    Toast.makeText(this, "Congratulations. You won!", Toast.LENGTH_SHORT).show()
                    hiddenAnswer.visibility = View.VISIBLE
                    button.visibility = View.INVISIBLE
                }

                button.setOnClickListener {

                    val view2: View? = this.currentFocus

                    // on below line checking if view is not null.
                    if (view2 != null) {
                        // on below line we are creating a variable
                        // for input manager and initializing it.
                        val inputMethodManager =
                            getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

                        // on below line hiding our keyboard.
                        inputMethodManager.hideSoftInputFromWindow(view2.getWindowToken(), 0)
                    }

                    val strValue: String = guess.text.toString().uppercase()
                    guess.text.clear()
                    textView3.text = strValue
                    textView3.visibility = View.VISIBLE
                    textView4.text = checkGuess(strValue)
                    textView4.visibility = View.VISIBLE
                    if (textView4.text == "OOOO") {
                        Toast.makeText(this, "Congratulations. You won!", Toast.LENGTH_SHORT).show()
                        hiddenAnswer.visibility = View.VISIBLE
                        button.visibility = View.INVISIBLE
                    }

                    button.setOnClickListener {

                        val view3: View? = this.currentFocus

                        // on below line checking if view is not null.
                        if (view3 != null) {
                            // on below line we are creating a variable
                            // for input manager and initializing it.
                            val inputMethodManager =
                                getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

                            // on below line hiding our keyboard.
                            inputMethodManager.hideSoftInputFromWindow(view3.getWindowToken(), 0)
                        }

                        val strValue: String = guess.text.toString().uppercase()
                        guess.text.clear()
                        textView5.text = strValue
                        textView5.visibility = View.VISIBLE
                        textView6.text = checkGuess(strValue)
                        textView6.visibility = View.VISIBLE
                        hiddenAnswer.visibility = View.VISIBLE
                        button.visibility = View.INVISIBLE
                        if (textView6.text == "OOOO") {
                            Toast.makeText(this, "Congratulations. You won!", Toast.LENGTH_LONG)
                                .show()
                        } else {
                            Toast.makeText(
                                this,
                                "Game over. You've exceeded the number of guesses",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
        }
    }
}

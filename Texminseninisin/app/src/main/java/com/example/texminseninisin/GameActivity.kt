package com.example.texminseninisin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.texminseninisin.databinding.ActivityGameBinding
import java.util.Random

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding

    private var randomNumber = 0
    private var counter = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        randomNumber = Random().nextInt(15)
        Log.e("Random Number", randomNumber.toString())

        binding.buttonGuess.setOnClickListener {
            val guessString = binding.editText.text.toString()
            if (guessString != "") {
                counter--
                if (guessString.toInt() == randomNumber) {
                    val intent = Intent(this@GameActivity, ResultActivity::class.java)

                    intent.putExtra("result", true)
                    intent.putExtra("trueNumber",randomNumber)
                    finish()
                    startActivity(intent)

                    return@setOnClickListener
                }
                if (guessString.toInt() > randomNumber) {
                    binding.textViewUpDown.text = "Azalt"
                    binding.textViewGuessNumber.text = "Təxmin sayı: $counter"
                }
                if (guessString.toInt() < randomNumber) {
                    binding.textViewUpDown.text = "Artır"
                    binding.textViewGuessNumber.text = "Təxmin sayı: $counter"
                }
                if (counter <= 0) {
                    val intent = Intent(this@GameActivity, ResultActivity::class.java)

                    intent.putExtra("result", false)
                    intent.putExtra("trueNumber",randomNumber)
                    finish()
                    startActivity(intent)
                }
                binding.editText.setText("")
            } else {
                Toast.makeText(this, "bos", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
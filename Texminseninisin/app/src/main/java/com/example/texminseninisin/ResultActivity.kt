package com.example.texminseninisin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.texminseninisin.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityResultBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        val result=intent.getBooleanExtra("result",false)
        val trueNumber=intent.getIntExtra("trueNumber",0)
        if (result){
            binding.textView2.text="Qazandınız"
            binding.imageView.setImageResource(R.drawable.baseline_sentiment_very_satisfied_24)
        }else{
            binding.textView2.text="Məğlub oldunuz"
            binding.imageView.setImageResource(R.drawable.baseline_sentiment_very_dissatisfied_24)
        }
        binding.textView3.text="Ədəd: $trueNumber"
        binding.buttonTryAgain.setOnClickListener {
            val intent=Intent(this@ResultActivity,MainActivity::class.java)
            finish()

            startActivity(intent)
        }
    }
}
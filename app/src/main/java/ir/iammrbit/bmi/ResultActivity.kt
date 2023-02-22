package ir.iammrbit.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.iammrbit.bmi.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }


}
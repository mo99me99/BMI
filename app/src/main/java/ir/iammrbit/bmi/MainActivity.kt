package ir.iammrbit.bmi
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ir.iammrbit.bmi.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var weight : Int?= null
    private var height : Int?= null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val btnCalculate = binding.btnCalculate
        btnCalculate.setOnClickListener{
            //get values from et
            weight = Integer.valueOf(binding.etWeight.text.toString())
            height = Integer.valueOf(binding.etHeight.text.toString())

            //create intent and put values to ResultActivity
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(Constant.WEIGHT.toString(),weight)
            intent.putExtra(Constant.WEIGHT.toString(),weight)
            startActivity(intent)
        }

        //initialize variables
    }

}
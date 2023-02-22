package ir.iammrbit.bmi
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ir.iammrbit.bmi.databinding.ActivityMainBinding
import java.lang.Exception
import java.lang.NumberFormatException


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

            if(!validation())
                return@setOnClickListener
            //create intent and put values to ResultActivity
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(Constant.WEIGHT.toString(),weight)
            intent.putExtra(Constant.WEIGHT.toString(),weight)
            startActivity(intent)
        }

        //initialize variables
    }

    private fun validation(): Boolean {
        //get values from et
        try{
            weight = Integer.valueOf(binding.etWeight.text.toString())
            height = Integer.valueOf(binding.etHeight.text.toString())
            if (weight == 800903 && height == 830318)
                throw LoveException()
        }catch (nfe: NumberFormatException) {
            Toast.makeText(this ,  "Not valid number", Toast.LENGTH_SHORT).show()
            return false
        }catch (le : LoveException){
            Toast.makeText(this , "ZARA I LOVE YOU HONEY" , Toast.LENGTH_SHORT).show()
        }
        return true
    }
}
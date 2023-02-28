package ir.iammrbit.bmi

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import ir.iammrbit.bmi.databinding.ActivityResultBinding
import java.lang.ArithmeticException

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    private var weight : Float? = null
    private var height : Float? = null
    private var bmiResult : Float? = null
    private var zara : Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        val actionBar: androidx.appcompat.app.ActionBar? = supportActionBar
        actionBar!!.hide()
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //init view elements
        val tvResult :TextView = binding.tvResult
        val tvMessage :TextView = binding.tvMessage
        //get values from intent
        weight = intent.getFloatExtra(Constant.WEIGHT, 0.0F)
        height = (intent.getFloatExtra(Constant.HEIGHT , 0F)/100)
        zara = intent.getBooleanExtra(Constant.Z , false)

        //calculate bmi
        bmiResult = calculateBMI()
        //set result
        
        bmiShow(tvResult, tvMessage)
    }

    private fun zara(tvResult: TextView, tvMessage: TextView) {
        binding.tvYourBMIis.text = ""
        tvResult.text = ""
        tvMessage.text = "I Love You Honey"
        binding.ivImage.setImageResource(R.drawable.ic_z)
    }

    private fun bmiShow(tvResult: TextView, tvMessage: TextView) {
        if (!(bmiResult!! < 0F || bmiResult!! > 100F))
            tvResult.text = bmiResult.toString().substring(0, bmiResult.toString().length - 3)
        else {
            tvResult.text = "This app is for human kind! "
            binding.tvYourBMIis.text = ""
        }
        when (bmiResult!!) {
            in 0F..18.5F -> {
                tvMessage.text = "You are underweight "
                tvMessage.setTextColor(Color.parseColor("#FF06D2B4"))
            }
            in 18.5F..24.99F -> {
                tvMessage.text = "You are normal "
                tvMessage.setTextColor(Color.parseColor("#27B707"))
            }
            in 24.99F..29.99F -> {
                tvMessage.text = "You are overweight "
                tvMessage.setTextColor(Color.parseColor("#FCB004"))
            }
            in 29.99F..34.99F -> {
                tvMessage.text = "You are obese "
                tvMessage.setTextColor(Color.parseColor("#FA6707"))
            }
            in 34.99F..75F -> {
                tvMessage.text = "You are extremly obese "
                tvMessage.setTextColor(Color.parseColor("#FF1700"))
            }
            else -> "NOT VALID ENTRIES !"
        }
    }

    private fun calculateBMI() : Float {
        return (weight!! / (height!! * height!!))
    }



}

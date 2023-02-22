package ir.iammrbit.bmi
import android.app.ActionBar
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ir.iammrbit.bmi.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var weight : Float?= null
    private var height : Float?= null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val actionBar: androidx.appcompat.app.ActionBar? = supportActionBar
        actionBar!!.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
            intent.putExtra(Constant.HEIGHT.toString(),height)
            Log.i("///////////////","$weight")
            Log.i("///////////////","$height")
            startActivity(intent)
        }

        //initialize variables
    }

    private fun validation(): Boolean {
        //get values from et
        try{
            weight = (binding.etWeight.text.toString()).toFloat()
            height = (binding.etHeight.text.toString()).toFloat()

            if (weight == 800903F && height == 830318F)
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
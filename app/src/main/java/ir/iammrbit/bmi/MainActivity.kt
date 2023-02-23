package ir.iammrbit.bmi
import android.app.ActionBar
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ir.iammrbit.bmi.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var weight : Float?= null
    private var height : Float?= null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)///instead of binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val actionBar: androidx.appcompat.app.ActionBar? = supportActionBar
        actionBar!!.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        val btnCalculate = binding.btnCalculate
        btnCalculate.setOnClickListener{

            if(!validation())
                return@setOnClickListener

            //create intent and put values to ResultActivity
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(Constant.WEIGHT.toString(),weight)
            intent.putExtra(Constant.HEIGHT.toString(),height)
            startActivity(intent)
        }

    }

    private fun validation(): Boolean {
        //get values from et
        try{
            weight = findViewById<EditText>(R.id.etWeight).text.toString().toFloat()
            weight = findViewById<EditText>(R.id.etHeight).text.toString().toFloat()
//            height = (binding.etHeight.text.toString()).toFloat()
            if (weight == 800903F && height == 830318F)
                throw LoveException()
        }catch (nfe: Exception) {
            Toast.makeText(this ,  "Not valid number", Toast.LENGTH_SHORT).show()
            return false
        }catch (le : Exception){
            Toast.makeText(this , "ZARA I LOVE YOU HONEY" , Toast.LENGTH_SHORT).show()
        }
        return true
    }
}
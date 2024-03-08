package net.uniquecomputer.intentform

import android.content.Intent
import android.media.MediaCodec
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import net.uniquecomputer.intentform.databinding.ActivityMainBinding
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
   lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val name = binding.name.text.toString()
        val number = binding.number.text.toString()
        val age = binding.age.text.toString()

            binding.btn.setOnClickListener {

                if (name.isEmpty()){
                    binding.nameInput.error ="Enter Correct Name"
                    Toast.makeText(this, "Enter Correct Name", Toast.LENGTH_SHORT).show()
                }else if (number.isEmpty() && Patterns.PHONE.matcher(number).matches()){
                    Toast.makeText(this, "Number", Toast.LENGTH_SHORT).show()
                }else if (age<= 0.toString() && age.isEmpty()){
                    Toast.makeText(this, "Enter Correct Age", Toast.LENGTH_SHORT).show()
                }else{
                    val intent = Intent(this, Data::class.java)
                    intent.putExtra("name", name)
                    intent.putExtra("number", number)
                    intent.putExtra("age", age)
                    startActivity(intent)
                }


            }

    }


}
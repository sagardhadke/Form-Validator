package net.uniquecomputer.intentform

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import net.uniquecomputer.intentform.databinding.ActivityDataBinding

class Data : AppCompatActivity() {
    lateinit var binding: ActivityDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val getname = binding.fullName

        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("number")
        val age = intent.getStringExtra("age")
//        val gender = intent.getStringExtra("gender")

        getname.text = name
        binding.number.text = number
        binding.age.text = age
//        binding.gender.text = gender

    }
}
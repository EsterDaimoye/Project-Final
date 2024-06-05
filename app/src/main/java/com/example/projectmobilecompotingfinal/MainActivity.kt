
package com.example.projectmobilecompotingfinal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projectmobilecompotingfinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnstarted.setOnClickListener {
            val intent = Intent(this, Loginpage::class.java)
            intent.putExtra("key", "value")
            startActivity(intent)
        }
    }
}

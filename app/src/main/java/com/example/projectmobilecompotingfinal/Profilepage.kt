package com.example.projectmobilecompotingfinal
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projectmobilecompotingfinal.databinding.ActivityProfilepageBinding
import com.google.firebase.auth.FirebaseAuth


class Profilepage : AppCompatActivity() {
    private lateinit var binding: ActivityProfilepageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilepageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnlogout.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            Intent(this, Loginpage::class.java).also {
                    intent -> intent.flags= Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        }
        binding.pesans.setOnClickListener{
            Toast.makeText(this, "Anda klik icon pesan", Toast.LENGTH_SHORT).show()
        }
        binding.homes.setOnClickListener{
            startActivity(Intent(this, Homepage::class.java))
        }
        binding.carts.setOnClickListener{
            Toast.makeText(this, "Anda tekan icon share", Toast.LENGTH_SHORT).show()
        }
        binding.pesans.setOnClickListener{
            Toast.makeText(this, "Adna tekan icon pesan", Toast.LENGTH_SHORT).show()
        }

    }
}

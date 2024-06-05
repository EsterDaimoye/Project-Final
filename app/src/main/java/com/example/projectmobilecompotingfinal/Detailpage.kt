package com.example.projectmobilecompotingfinal
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projectmobilecompotingfinal.databinding.ActivityDetailpageBinding


class Detailpage : AppCompatActivity() {
    private lateinit var binding: ActivityDetailpageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailpageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val nameT = intent.getStringExtra("NAMET")
        val ketT = intent.getStringExtra("KETS")
        val desT = intent.getStringExtra("DESCRIT")
        val imgT = intent.getStringExtra("IMGURI")

        binding.juduldetail.text = nameT
        binding.ketdetail.text = ketT
        binding.ketfotodetail.text = desT
        binding.fotodetail.loadImage(imgT)
    }
}

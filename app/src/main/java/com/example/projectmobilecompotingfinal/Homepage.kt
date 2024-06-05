package com.example.projectmobilecompotingfinal

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectmobilecompotingfinal.databinding.ActivityHomepageBinding
import com.google.firebase.database.*

class Homepage : AppCompatActivity() {
    private lateinit var datalist: MutableList<Image>
    private lateinit var dataAdapter: ImageAdapter
    private lateinit var binding: ActivityHomepageBinding
    private var mDatabaseRef: DatabaseReference? = null
    private var mDBListener: ValueEventListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.papuans.setHasFixedSize(true)
        binding.papuans.layoutManager = LinearLayoutManager(this)

        binding.myDataLoaderProgressBar.visibility = View.VISIBLE
        datalist = ArrayList()
        dataAdapter = ImageAdapter(this, datalist)
        binding.papuans.adapter = dataAdapter

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("data")
        mDBListener = mDatabaseRef!!.addValueEventListener(object : ValueEventListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {
                datalist.clear()
                for (teacherSnapshot in snapshot.children) {
                    val upload = teacherSnapshot.getValue(Image::class.java)
                    if (upload != null) {
                        upload.key = teacherSnapshot.key
                        datalist.add(upload)
                    }
                }
                dataAdapter.notifyDataSetChanged()
                binding.myDataLoaderProgressBar.visibility = View.GONE
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Homepage, error.message, Toast.LENGTH_SHORT).show()
                binding.myDataLoaderProgressBar.visibility = View.INVISIBLE
            }
        })

        binding.prile.setOnClickListener{
            startActivity(Intent(this, Profilepage::class.java))
        }
        binding.carts.setOnClickListener{
            Toast.makeText(this, "Anda tekan icon share", Toast.LENGTH_SHORT).show()
        }
        binding.pesans.setOnClickListener{
            Toast.makeText(this, "Anda tekan icon pesan", Toast.LENGTH_SHORT).show()
        }
    }
}

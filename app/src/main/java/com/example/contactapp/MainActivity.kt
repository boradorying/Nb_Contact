package com.example.contactapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val profiles : MutableList<Profile> = mutableListOf()
    private lateinit var rvAdapter :ProfileAdapter


    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        rvAdapter = ProfileAdapter(profiles, object : ProfileAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {


                val clickedProfile = profiles[position]
                clickedProfile.bookmark = !clickedProfile.bookmark
                rvAdapter.notifyItemChanged(position)
            }
        })
        profiles.addAll(ProfileList.profiles)

        binding.RVArea.layoutManager = LinearLayoutManager(this)//매니저연결
        binding.RVArea.adapter = rvAdapter//어댑터랑 연결zㅋ_ㅋ
    }

}
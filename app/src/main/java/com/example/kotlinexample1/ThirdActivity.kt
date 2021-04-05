package com.example.kotlinexample1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinexample1.databinding.ActivityThirdBinding
import org.json.JSONObject

class ThirdActivity: AppCompatActivity() {
    // read in json file
    // create an arraylist of villagers
    // create adapter with the list of villagers
    // set it to recycler view

    private lateinit var villagersList: ArrayList<Villager>
    private lateinit var binding: ActivityThirdBinding
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recyclerViewVillagers;
        villagersList = ArrayList<Villager>()
        val jsonFileContent = loadJSONfromAssets("villagers.json")
        val jsonObject = JSONObject(jsonFileContent)
        val jsonArray = jsonObject.getJSONArray("villagers")
        for (i in 0 until jsonArray.length()){
            val villagerJSONObject = jsonArray.getJSONObject(i)
            val villager = Villager(villagerJSONObject.getString("name").toString(),
                                    villagerJSONObject.getString("birthday").toString(),
                                    villagerJSONObject.getString("phrase").toString(),
                                    villagerJSONObject.getString("house").toString(),
                                    villagerJSONObject.getString("villager").toString(),
                                    false)
            villagersList.add(villager)
        }
        recyclerView.adapter = VillagerAdapter(villagersList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
    }
    private fun loadJSONfromAssets(filename:String):String{
        return applicationContext.assets.open(filename).bufferedReader().use {it.readText()}
    }
}
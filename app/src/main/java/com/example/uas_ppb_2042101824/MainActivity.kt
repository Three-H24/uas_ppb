package com.example.uas_ppb_2042101824

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uas_ppb_2042101824.api.MealService
import com.example.uas_ppb_2042101824.databinding.ActivityMainBinding
import com.example.uas_ppb_2042101824.model.Meals
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var mealService: MealService
    private lateinit var binding: ActivityMainBinding
    private val kategori = "Seafood"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mealService = MealInstance.getMealInstance().create(MealService::class.java)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvMeals.layoutManager = LinearLayoutManager(this)
        loadFromAPI()
    }

    private fun loadFromAPI() {
        val responData: LiveData<Response<Meals>> = liveData {
            val response = mealService.getMeals(kategori)
            emit(response)
        }
        responData.observe(this, Observer {
            binding.rvMeals.adapter = MealsAdapter(
                it
            )
        })
    }
}
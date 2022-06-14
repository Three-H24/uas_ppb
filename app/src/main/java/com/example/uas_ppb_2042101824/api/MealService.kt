package com.example.uas_ppb_2042101824.api

import com.example.uas_ppb_2042101824.model.Meals
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MealService {
    @GET("/api/json/v1/1/filter.php")
    suspend fun getMeals(@Query("c") c: String?): Response<Meals>
}
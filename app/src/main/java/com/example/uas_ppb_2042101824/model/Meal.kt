package com.example.uas_ppb_2042101824.model


import com.google.gson.annotations.SerializedName

data class Meal(
    @SerializedName("idMeal")
    var idMeal: String?,
    @SerializedName("strMeal")
    var strMeal: String?,
    @SerializedName("strMealThumb")
    var strMealThumb: String?
)
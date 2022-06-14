package com.example.uas_ppb_2042101824.model

import com.google.gson.annotations.SerializedName

data class Meals(
    @SerializedName("meals")
    var meal: List<Meal?>?
)
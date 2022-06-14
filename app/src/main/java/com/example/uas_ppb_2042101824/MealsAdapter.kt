package com.example.uas_ppb_2042101824

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uas_ppb_2042101824.databinding.ItemMealsBinding
import com.example.uas_ppb_2042101824.model.Meal
import com.example.uas_ppb_2042101824.model.Meals
import retrofit2.Response

class MealsAdapter(
    private val meals: Response<Meals>,
) : RecyclerView.Adapter<MealsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealsViewHolder {
        val mealsBinding = ItemMealsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MealsViewHolder(mealsBinding)
    }

    override fun onBindViewHolder(holder: MealsViewHolder, position: Int) {
        holder.bind(meals.body()?.meal!![position])
    }

    override fun getItemCount(): Int {
        return meals.body()?.meal!!.size
    }

}

class MealsViewHolder(val binding: ItemMealsBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(meals: Meal?) {
        binding.apply {
            tvMeal.text = meals?.strMeal

            tvIdMeal.text = meals?.idMeal

            Glide.with(ivMeals.context).load(meals?.strMealThumb).into(ivMeals)
        }
    }
}
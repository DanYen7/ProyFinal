package com.example.proyfinal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyfinal.databinding.ItemSugerenciasBinding
import org.json.JSONArray
import org.json.JSONObject

class SugerenciasAdapter(private val articulo: JSONArray): RecyclerView.Adapter<SugerenciasAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SugerenciasAdapter.MainHolder {
        val binding = ItemSugerenciasBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: SugerenciasAdapter.MainHolder, position: Int) {
        holder.render(articulo.getJSONObject(position))
    }

    override fun getItemCount(): Int = articulo.length()

    class MainHolder(val binding: ItemSugerenciasBinding): RecyclerView.ViewHolder(binding.root){

        fun render(poke: JSONObject){
            binding.tvArticulo.setText(poke.getString("title"))
            binding.tvPrecio.setText(poke.getString("price"))
            binding.tvRating.setText(poke.getString("rating"))

        }
    }
}
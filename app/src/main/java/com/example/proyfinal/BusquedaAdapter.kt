package com.example.proyfinal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyfinal.databinding.ItemBusquedaBinding
import org.json.JSONArray
import org.json.JSONObject

class BusquedaAdapter(private val articulo: JSONArray): RecyclerView.Adapter<BusquedaAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = ItemBusquedaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.render(articulo.getJSONObject(position))
    }

    override fun getItemCount(): Int = articulo.length()

    class MainHolder(val binding: ItemBusquedaBinding): RecyclerView.ViewHolder(binding.root){

        fun render(art: JSONObject){
            binding.textView.setText(art.getString("title"))
        }
    }
}
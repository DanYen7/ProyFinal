package com.example.proyfinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.proyfinal.databinding.FragmentBusquedaBinding
import com.example.proyfinal.databinding.FragmentSugerenciasBinding
import com.example.proyfinal.databinding.ItemSugerenciasBinding
import org.json.JSONObject

class SugerenciasFragment : Fragment() {
    private lateinit var binding: FragmentSugerenciasBinding
    private lateinit var queue : RequestQueue
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSugerenciasBinding.inflate(layoutInflater)
        queue = Volley.newRequestQueue(context?.applicationContext)
        getArticulos()

        return inflater.inflate(R.layout.fragment_sugerencias, container, false)

    }

    private fun getArticulos() {
        val url = "https://fakestoreapi.com/products/5"
        val jsonRequest = JsonObjectRequest(url,Response.Listener<JSONObject> { response ->
            Log.i("JSONRESPONSE", response.getJSONArray("resultado").toString())
            binding.suger.adapter = BusquedaAdapter(response.getJSONArray("resultado"))
        },
            Response.ErrorListener { error ->
                Log.w("JSONRESPONSE",error.message as String)
            })

        queue.add(jsonRequest)
    }

}
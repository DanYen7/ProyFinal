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
import org.json.JSONObject

class BusquedaFragment : Fragment() {

    private lateinit var binding: FragmentBusquedaBinding
    private lateinit var queue : RequestQueue
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentBusquedaBinding.inflate(layoutInflater)
        queue = Volley.newRequestQueue(context?.applicationContext)
        binding.btnbuscar.setOnClickListener{
            val articulo = Integer.parseInt(binding.etbuscar.text.toString())
            getArticulos(articulo)
        }

        return inflater.inflate(R.layout.fragment_busqueda, container, false)

    }

    private fun getArticulos(articulo: Int) {
        val url = "https://fakestoreapi.com/products/${articulo}"
        val jsonRequest = JsonObjectRequest(url,Response.Listener<JSONObject> { response ->
            Log.i("JSONRESPONSE", response.getJSONArray("results").toString())
            binding.rvBusqueda.adapter = BusquedaAdapter(response.getJSONArray("resultado"))
        },
            Response.ErrorListener { error ->
                Log.w("JSONRESPONSE",error.message as String)
            })

        queue.add(jsonRequest)
    }

}
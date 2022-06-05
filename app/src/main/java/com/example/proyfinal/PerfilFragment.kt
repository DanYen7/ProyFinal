package com.example.proyfinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.volley.RequestQueue
import com.example.proyfinal.databinding.FragmentBusquedaBinding
import com.example.proyfinal.databinding.FragmentPerfilBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class PerfilFragment : Fragment() {

    private lateinit var binding: FragmentPerfilBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPerfilBinding.inflate(layoutInflater)
        val database = Firebase.database
        val myRef = database.reference

/*myRef.child("Usuario").child("1").setValue(Usuario("Daniel","DannyZen","Premium",""))
myRef.child("Usuario").child("2").setValue(Usuario("Carmen", "CML","Premium", "Aretes"))
myRef.child("Usuario").child("3").setValue(Usuario("Ana","Anita","Básico","Tacones"))*/

        myRef.child("Usuario").get().addOnSuccessListener { response ->
            binding.tvUsuario.setText(myRef.get().toString())
            binding.tvNombre.setText(myRef.get().toString())
            binding.tvNivel.setText(myRef.get().toString())
            binding.btnCarrito.setText(myRef.get().toString())
        }.addOnFailureListener{
            Log.e("firebaseResponse", "Error getting data", it)
        }

return inflater.inflate(R.layout.fragment_perfil, container, false)
}}
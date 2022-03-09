package com.recu.tienda.ui.view


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.recu.tienda.core.NetworkManager
import com.recu.tienda.data.model.ProductObjectItem
import com.recu.tienda.databinding.FragmentProductListBinding
import kotlinx.android.synthetic.main.fragment_product_add.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.navigation.NavController
import com.google.gson.annotations.SerializedName


class ProductListFragment : Fragment() {


    private var _binding: FragmentProductListBinding? = null
    private val binding
        get() = _binding!!
    private val adapter = ProductAdapter {


        val hacedor = ProductListFragmentDirections.actionProductListFragmentToProductDetailFragment(
            it.id,
            it.description,
            it.available,
            it.price,
            it.name,
            it.imageUrl,
            it.stock,
            it.discountPrice




    
        )
        findNavController().navigate(hacedor)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.rvProduct.layoutManager = GridLayoutManager(context, 2)
        binding.rvProduct.adapter = adapter
        binding.btnAdd.setOnClickListener{
            val hacedor = ProductListFragmentDirections.actionProductListFragmentToProductAddFragment(
            )
            findNavController().navigate(hacedor)
        }
        requestData()
    }


    private fun requestData() {

        NetworkManager.service.getProducts().enqueue(object : Callback<List<ProductObjectItem>> {


            override fun onFailure(call: Call<List<ProductObjectItem>>, t: Throwable) {
                Toast.makeText(
                    context,
                    "¡Error! Algo no ha salido como esperábamos",
                    Toast.LENGTH_SHORT
                ).show()
                Log.e("Retrofit", "Error: ${t.localizedMessage}", t)
            }

            override fun onResponse(
                call: Call<List<ProductObjectItem>>,
                response: Response<List<ProductObjectItem>>
            ) {
                if (response.isSuccessful) {
                    adapter.submitList(response.body())
                    Log.e("Retrofit", "Todo salió bien!")
                } else {
                    Toast.makeText(context, "400", Toast.LENGTH_SHORT).show()
                }
            }

        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}






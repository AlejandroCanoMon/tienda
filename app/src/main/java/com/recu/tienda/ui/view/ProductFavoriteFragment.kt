package com.recu.tienda.ui.view
import android.database.Cursor
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.recu.tienda.data.model.ProductObjectItem
import com.recu.tienda.databinding.FragmentProductFavBinding


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// TODO: Rename parameter arguments, choose names that match

class ProductFavFragment : Fragment() {


    private var _binding: FragmentProductFavBinding? = null
    private val binding
        get() = _binding!!

    private val adapter = ProductAdapter {
        db.getQuoteDao().deleteProd(it.name)
        //val action = ProductFavFragmentDirections.actionProductFavFragment2ToProductDetailFragment(
        //  it.id
        //)
        //findNavController().navigate(action)
        refreshProducts()
        checkEmpty()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductFavBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState:Bundle?){
        super.onViewCreated(view, savedInstanceState)

        checkEmpty()
        binding.recyclerView2.layoutManager = GridLayoutManager(context, 2)
        binding.recyclerView2.adapter = adapter
        refreshProducts()
    }


    private fun checkEmpty(){
        val mCursor: MutableList<ProductObjectItem> = db.getQuoteDao().findProducts()

        if(mCursor.size == 0){
            binding.lblnfo.text = "Lista de favoritos vacía"
            binding.noFavIcon.visibility = View.VISIBLE
        }
        else{
            binding.lblnfo.text = "Pulsa para eliminar"
            binding.noFavIcon.visibility = View.INVISIBLE
        }
    }
    private fun refreshProducts() {
        val products = db.getQuoteDao().findProducts()
        adapter.submitList(products)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
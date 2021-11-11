package com.example.recyclerviewupdating1.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.recyclerviewupdating1.R
import com.example.recyclerviewupdating1.databinding.MainFragmentBinding


class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout XML file and return a binding object instance
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nbItems.text = activity?.resources?.getString(R.string.nbItems, viewModel.items.size.toString())

        val CallbackClickItem = { pos: Int ->
            viewModel.remove(pos)
            binding.nbItems.text = activity?.resources?.getString(R.string.nbItems, viewModel.items.size.toString())
        }
        val itemAdapter=ItemAdapter(viewModel.items, CallbackClickItem)
        binding.recyclerView.adapter = itemAdapter


        binding.fab.setOnClickListener{
            viewModel.addItem()
            itemAdapter.notifyDataSetChanged()
        }
    }
}
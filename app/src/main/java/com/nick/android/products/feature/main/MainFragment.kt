package com.nick.android.products.feature.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.nick.android.products.databinding.MainFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var binding: MainFragmentBinding? = null
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = MainFragmentBinding.inflate(inflater, container, false).apply {
        val productAdapter = ProductAdapter {
            findNavController().navigate(MainFragmentDirections.actionMainToDetail(it))
        }
        val layout = LinearLayoutManager(context)

        rcView.apply {
            layoutManager = layout
            adapter = productAdapter
        }

        swipeRefreshLayout.setOnRefreshListener { viewModel.update() }

        viewModel.products.observe(viewLifecycleOwner) {
            productAdapter.submitList(it) { layout.scrollToPositionWithOffset(0, 0) }
            swipeRefreshLayout.isRefreshing = false
        }
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
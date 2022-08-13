package com.bignerdranch.android.leagues

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.leagues.databinding.MainFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var binding: MainFragmentBinding? = null
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = MainFragmentBinding.inflate(inflater, container, false).apply {
        val leagueAdapter = LeagueAdapter {
            findNavController().navigate(MainFragmentDirections.actionMainToDetail(it))
        }
        val layout = LinearLayoutManager(context)

        rcView.apply {
            layoutManager = layout
            adapter = leagueAdapter
        }

        mix.setOnClickListener { viewModel.update() }

        viewModel.leagues.observe(viewLifecycleOwner) { leagueAdapter.submitList(it){
            layout.scrollToPositionWithOffset(0, 0)
        } }
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
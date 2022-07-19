package com.bignerdranch.android.leagues

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.leagues.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private var leagueAdapter: LeagueAdapter? = null
    private var binding: MainFragmentBinding? = null
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = MainFragmentBinding.inflate(inflater, container, false).apply {
        leagueAdapter = LeagueAdapter {
            findNavController().navigate(MainFragmentDirections.actionMainToDetail(it))
        }

        rcView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = leagueAdapter
        }

        mix.setOnClickListener { viewModel.update() }
        viewModel.leagues.observe(viewLifecycleOwner) { leagueAdapter?.setLeagues(it) }
    }.root


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        leagueAdapter = null
    }
}
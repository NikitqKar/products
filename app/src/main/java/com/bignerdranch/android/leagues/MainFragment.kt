package com.bignerdranch.android.leagues

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.leagues.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private var binding: MainFragmentBinding? = null

    private val leagueListViewModel: LeagueListViewModel by lazy {
        ViewModelProvider(this)[LeagueListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainFragmentBinding.inflate(inflater, container, false)

        val leagueAdapter = LeagueAdapter(leagueListViewModel.leagues) {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, NewFragment.newInstance(it))
                .addToBackStack(it.title)
                .commit()
        }

        binding?.rcView?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = leagueAdapter
        }

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}
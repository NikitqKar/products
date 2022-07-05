package com.bignerdranch.android.leagues

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainFragment : Fragment() {

    private val leagueListViewModel: LeagueListViewModel by lazy {
        ViewModelProviders.of(this).get(LeagueListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        val rcView = view.findViewById(R.id.rcView) as RecyclerView

        val leagueAdapter = LeagueAdapter(leagueListViewModel.leagues) {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, NewFragment.newInstance())
                .addToBackStack(it.title)
                .commit()
        }

        rcView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = leagueAdapter
        }

        return view
    }

    companion object {
        fun newInstance() = MainFragment()

    }
}
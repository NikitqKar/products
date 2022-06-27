package com.bignerdranch.android.leagues

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainFragment : Fragment() {

    private lateinit var leagueRecyclerView: RecyclerView
    private var adapter: LeagueAdapter? = null

    private val leagueListViewModel: LeagueListViewModel by lazy {
        ViewModelProviders.of(this).get(LeagueListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_fragment, container, false)

        leagueRecyclerView =
            view.findViewById(R.id.rcView) as RecyclerView
        leagueRecyclerView.layoutManager = LinearLayoutManager(context)

        updateUI()

        return view
    }

    private fun updateUI() {
        val leagues = leagueListViewModel.Leagues
        adapter = LeagueAdapter(leagues)
        leagueRecyclerView.adapter = adapter
    }

    private inner class LeagueHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        private lateinit var league: League

        private val titleTextView: TextView = itemView.findViewById(R.id.league_title)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(league: League) {
            this.league = league
            titleTextView.text = this.league.title
        }

        override fun onClick(v: View) {
            Toast.makeText(context, "${league.title} clicked!", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private inner class LeagueAdapter(var Leagues: List<League>) : RecyclerView.Adapter<LeagueHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
                : LeagueHolder {
            val view = layoutInflater.inflate(R.layout.list_item_league, parent, false)
            return LeagueHolder(view)
        }

        override fun onBindViewHolder(holder: LeagueHolder, position: Int) {
            val league = Leagues[position]
            holder.bind(league)
        }

        override fun getItemCount() = Leagues.size
    }

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }
}
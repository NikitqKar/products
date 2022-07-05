package com.bignerdranch.android.leagues

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LeagueAdapter(
    private val leagues: List<League>,
    private val onItemClick: ((League) -> Unit)
) : RecyclerView.Adapter<LeagueAdapter.LeagueHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LeagueHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.list_item_league, parent, false)
    )

    override fun onBindViewHolder(holder: LeagueHolder, position: Int) {
        holder.bind(leagues[position])
    }

    override fun getItemCount() = leagues.size

    inner class LeagueHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val titleTextView: TextView = itemView.findViewById(R.id.league_title)

        fun bind(league: League) {
            view.setOnClickListener { onItemClick(league) }
            titleTextView.text = league.title
        }
    }
}
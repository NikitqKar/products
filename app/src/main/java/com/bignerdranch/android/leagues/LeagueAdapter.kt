package com.bignerdranch.android.leagues

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.leagues.databinding.ListItemLeagueBinding

class LeagueAdapter(
    private val leagues: List<League>,
    private val onItemClick: ((League) -> Unit)
) : RecyclerView.Adapter<LeagueAdapter.LeagueHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LeagueHolder(
        ListItemLeagueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: LeagueHolder, position: Int) {
        holder.bind(leagues[position])
    }

    override fun getItemCount() = leagues.size

    inner class LeagueHolder(private val binding: ListItemLeagueBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(league: League) {
            binding.root.setOnClickListener { onItemClick(league) }
            binding.leagueTitle.text = league.title
        }
    }
}
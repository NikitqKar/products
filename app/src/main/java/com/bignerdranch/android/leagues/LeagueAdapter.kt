package com.bignerdranch.android.leagues

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.leagues.databinding.ListItemLeagueBinding
import com.squareup.picasso.Picasso

class LeagueAdapter(
    private val onItemClick: ((League) -> Unit)
) : RecyclerView.Adapter<LeagueAdapter.LeagueHolder>() {

    private var leagues: List<League> = listOf()

    fun setLeagues(newLeagues: List<League>) {
        leagues = newLeagues
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LeagueHolder(
        ListItemLeagueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: LeagueHolder, position: Int) {
        holder.bind(leagues[position])
    }

    override fun getItemCount() = leagues.size

    fun setData(newLeagueList : List<League>){
        val diffUtil = LeagueItemDiffCallback(leagues, newLeagueList)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        leagues = newLeagueList
        diffResults.dispatchUpdatesTo(this)
    }

    inner class LeagueHolder(private val binding: ListItemLeagueBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(league: League) {
            binding.root.setOnClickListener { onItemClick(league) }
            binding.leagueTitle.text = league.name
            Picasso.get()
                .load(league.logos.light)
                .into(binding.imageView)
        }
    }
}
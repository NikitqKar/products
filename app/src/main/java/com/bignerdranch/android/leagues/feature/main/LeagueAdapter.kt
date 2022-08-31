package com.bignerdranch.android.leagues.feature.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.leagues.data.entity.League
import com.bignerdranch.android.leagues.databinding.ListItemLeagueBinding
import coil.load
import coil.transform.CircleCropTransformation

class LeagueAdapter(private val onItemClick: ((League) -> Unit)) :
    ListAdapter<League, LeagueAdapter.LeagueHolder>(LeagueDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LeagueHolder(
        ListItemLeagueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: LeagueHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class LeagueHolder(private val binding: ListItemLeagueBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(league: League) {
            binding.apply {
                root.setOnClickListener { onItemClick(league) }

                leagueTitle.text = league.name

                imageView.load(league.logos.light) {
                    crossfade(true)
                    transformations(CircleCropTransformation())


                }
            }
        }
    }
}

class LeagueDiff : DiffUtil.ItemCallback<League>() {

    override fun areContentsTheSame(oldItem: League, newItem: League) = oldItem == newItem

    override fun areItemsTheSame(oldItem: League, newItem: League) = oldItem.id == newItem.id
}

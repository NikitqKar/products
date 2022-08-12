package com.bignerdranch.android.leagues

import androidx.recyclerview.widget.DiffUtil

class LeagueItemDiffCallback(var oldList: List<League>, var newList: List<League>): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{
            oldList[oldItemPosition].id != newList[newItemPosition].id ->{
                false
            }
            oldList[oldItemPosition].name != newList[newItemPosition].name ->{
                false
            }
            else -> true
        }

    }

}
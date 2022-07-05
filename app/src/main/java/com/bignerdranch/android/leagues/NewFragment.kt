package com.bignerdranch.android.leagues

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bignerdranch.android.leagues.databinding.DetailedFragmentBinding

class NewFragment : Fragment() {

    private var binding: DetailedFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailedFragmentBinding.inflate(inflater, container, false).apply {
            val league = (arguments?.get("data") as League)
            tvDeteiled.text = league.title
        }
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        fun newInstance(league: League) = NewFragment().apply {
            arguments = Bundle().apply { putParcelable("data", league) }
        }
    }
}
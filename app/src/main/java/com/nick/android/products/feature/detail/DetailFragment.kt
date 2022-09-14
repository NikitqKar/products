package com.nick.android.products.feature.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import com.nick.android.products.databinding.DetailedFragmentBinding

class DetailFragment : Fragment() {

    private var binding: DetailedFragmentBinding? = null
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = DetailedFragmentBinding.inflate(inflater, container, false).apply {
        binding = this
        tvDeteiled.text = args.product.title
        imView.load(args.product.thumbnail)
    }.root


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
package com.example.dentiappdoctor.Ui.Cajeros

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dentiappdoctor.databinding.FragmentOrdenesFactBinding


class OrdenesFactFragment : Fragment() {

    private var _binding: FragmentOrdenesFactBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentOrdenesFactBinding.inflate(inflater, container, false)
        return binding.root



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
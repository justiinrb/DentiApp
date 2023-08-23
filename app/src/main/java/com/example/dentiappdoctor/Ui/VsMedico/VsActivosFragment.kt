package com.example.dentiappdoctor.Ui.VsMedico

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dentiappdoctor.databinding.FragmentVsActivosBinding


class VsActivosFragment : Fragment() {

    private var _binding: FragmentVsActivosBinding? = null


    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentVsActivosBinding.inflate(inflater, container, false)
        return binding.root
    }



    }
package com.example.dentiappdoctor.Ui.Operaciones

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dentiappdoctor.R
import com.example.dentiappdoctor.ViewModel.InactivosOPViewModel
import com.example.dentiappdoctor.ViewModelFactory.InactivosOPVMFactory

import com.example.dentiappdoctor.databinding.FragmentInactivosOPBinding
import com.example.dentiappdoctor.repository.InactivosOPRepository
import com.example.dentiappdoctor.utils.ActionBtnSheetFragment


class InactivosOPFragment : Fragment() {

    private lateinit var vModelInactivos : InactivosOPViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter:AdapDocInactivosOP
    private lateinit var imageButton: ImageButton

    private var _binding: FragmentInactivosOPBinding? = null

    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentInactivosOPBinding.inflate(inflater, container, false)
        recyclerView = binding.recyclerDoc
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vModelInactivos = InactivosOPViewModel(InactivosOPRepository())
        val reponIactivos = InactivosOPRepository()
        val viewMInactivosFactory = InactivosOPVMFactory(reponIactivos)
        vModelInactivos = ViewModelProvider(this,viewMInactivosFactory).get(InactivosOPViewModel::class.java)

        vModelInactivos.InactivosOPVM(
            "18/7/2023","17/8/2023",50,1
        )

        vModelInactivos.resultInactivos.observe(viewLifecycleOwner, Observer {response->
            val listaDoctores = response?.contentInactivosOP?.doctoresInactivosOPS
            if (listaDoctores != null) {
                val adapter = AdapDocInactivosOP(requireContext(), listaDoctores)
                recyclerView.adapter = adapter
            }
        println("InactivosOPPPPPP "+response?.codigo)
            binding.progressBarInactivos.visibility = View.GONE

        })

        binding.progressBarInactivos.visibility = View.VISIBLE
    }
}
package com.example.dentiappdoctor.Ui.Operaciones

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.Observer
import com.example.dentiappdoctor.ViewModel.DocGetViewModel
import com.example.dentiappdoctor.ViewModelFactory.GetDocVMFactory
import com.example.dentiappdoctor.databinding.FragmentActivosOPBinding
import com.example.dentiappdoctor.repository.DocGetRepository


class ActivosOPFragment : Fragment() {


    private lateinit var viewMDoctores: DocGetViewModel
    private lateinit var recyclerView: RecyclerView


    private var _binding: FragmentActivosOPBinding? = null

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
        _binding = FragmentActivosOPBinding.inflate(inflater, container, false)

        recyclerView = binding.recyclerDoc
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewMDoctores = DocGetViewModel(DocGetRepository())
        val repositoryGetDoc = DocGetRepository()
        val viewGDFactory = GetDocVMFactory(repositoryGetDoc)
        viewMDoctores = ViewModelProvider(this, viewGDFactory).get(DocGetViewModel::class.java)


        viewMDoctores.GetDocVM(
            25,
            1
        )
        viewMDoctores.resultGDoc.observe(viewLifecycleOwner, Observer { response ->

            val listaDoctores = response?.contentDoctor?.doctoresActivos
            if (listaDoctores != null) {
                val adapter = AdapterDoctores(requireContext(), listaDoctores)
                recyclerView.adapter = adapter
            }

            println("RespuestaRes" + response?.codigo)
            binding.progressBarActivos.visibility = View.GONE
        })
        binding.progressBarActivos.visibility = View.VISIBLE
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
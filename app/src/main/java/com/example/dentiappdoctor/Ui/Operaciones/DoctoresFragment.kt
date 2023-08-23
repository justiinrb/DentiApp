package com.example.dentiappdoctor.Ui.Operaciones

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProvider

import com.example.dentiappdoctor.databinding.FragmentDoctoresBinding
import androidx.lifecycle.Observer
import com.example.dentiappdoctor.ViewModel.SectorCViewModel
import com.example.dentiappdoctor.ViewModel.ZonaViewModel
import com.example.dentiappdoctor.ViewModelFactory.SectorVMFactory
import com.example.dentiappdoctor.ViewModelFactory.ZonaVMFactory
import com.example.dentiappdoctor.model.MZona_Ciudad.ContentZonaCiudad
import com.example.dentiappdoctor.model.ModelSectorC.ContentSectorCiudad

import com.example.dentiappdoctor.repository.SectorCRepository
import com.example.dentiappdoctor.repository.ZonaRepository
import com.example.dentiappdoctor.utils.ActionBtnSheetFragment
import com.example.dentiappdoctor.utils.SharVModel


class  DoctoresFragment : Fragment() {

    private var _binding: FragmentDoctoresBinding? = null

    private lateinit var vmodelSector: SectorCViewModel
    private lateinit var vmodelZona:ZonaViewModel
    private val binding get() = _binding!!
    private lateinit var actionBtnSheet: ActionBtnSheetFragment
    private  var zonaList:List<Parcelable> = emptyList()
    private  var sectorList:List<Parcelable> = emptyList()
    private lateinit var sharedViewModel: SharVModel

    private var Strinnnn  = " sdfdfsfsf"

    interface OnDataSendListener {
        fun onDataSend(data: List<ContentSectorCiudad>? = null)
    }

    interface OnDataZonaListener{
        fun onDataZona(listZona:List<ContentZonaCiudad>?= null)
    }
    private var onDataSendListener: OnDataSendListener? = null

    private var Ondatazonalistener : OnDataZonaListener? = null

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
        _binding = FragmentDoctoresBinding.inflate(inflater, container, false)
        zonaList = listOf()




        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.viewPager.adapter = TabAdapter(childFragmentManager)
        binding.tabLayout.setupWithViewPager(binding.viewPager)



        vmodelSector = SectorCViewModel(SectorCRepository())
        val repositorySector = SectorCRepository()
        val viewMFActory = SectorVMFactory(repositorySector)
        vmodelSector = ViewModelProvider(this,viewMFActory).get(SectorCViewModel::class.java)

        vmodelSector.SectorVM(
            "SECTOR_CIUDAD"
        )
        vmodelSector.resulSector.observe(viewLifecycleOwner,Observer{Response->
            println("SectorResponse "+ Response?.codigo)
            onDataSendListener?.onDataSend(Response?.contentSectorCiudad)


        })


        vmodelZona = ZonaViewModel(ZonaRepository())
        val repoZona = ZonaRepository()
        val viewZonaFactory = ZonaVMFactory(repoZona)
        vmodelZona = ViewModelProvider(this,viewZonaFactory).get(ZonaViewModel::class.java)

        vmodelZona.zonaVM(
            "ZONA_CIUDAD"
        )
        vmodelZona.resulVZona.observe(viewLifecycleOwner, Observer {Response->
            println("ZonaResponsees " + Response?.codigo)
            Ondatazonalistener?.onDataZona(Response?.contentZonaCiudad)



            sharedViewModel = ViewModelProvider(requireActivity()).get(SharVModel::class.java)
            sharedViewModel.showListEvent.observe(viewLifecycleOwner, Observer {
                // Cuando se detecte el evento de mostrar la lista, realiza las acciones necesarias aquí
                // Puedes acceder a las listas desde el ViewModel compartido si es necesario
                val sectorList = sharedViewModel.sectorCiudadList.value
                val zonaList = sharedViewModel.zonaCiudadList.value

                val zonaListSize = zonaList?.count()?: 0

                println("TAMANQOOzonaaa $zonaListSize")
                println("FDOCTORESFRAAment")
            })


        })


        }
    fun setOnDataSendListener(listener: OnDataSendListener) {
        this.onDataSendListener = listener
    }

    fun setOnDataZonaList(listener: OnDataZonaListener){
        this.Ondatazonalistener = listener
    }




    inner class TabAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> ActivosOPFragment()
                1 -> InactivosOPFragment()
                else -> throw IllegalArgumentException("Invalid position")
            }
        }

        override fun getCount(): Int = 2

        override fun getPageTitle(position: Int): CharSequence? {
            return when (position) {
                0 -> "Active Accounts"
                1 -> "Inactive Accounts"
                else -> null
            }
        }
    }



}





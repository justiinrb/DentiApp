package com.example.dentiappdoctor.utils

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dentiappdoctor.R
import com.example.dentiappdoctor.ViewModel.FiltracionViewModel
import com.example.dentiappdoctor.ViewModelFactory.FiltracionVMFactory
import com.example.dentiappdoctor.databinding.FragmentBottomsheetlayoutBinding
import com.example.dentiappdoctor.model.MZona_Ciudad.ContentZonaCiudad
import com.example.dentiappdoctor.model.ModelSectorC.ContentSectorCiudad
import com.example.dentiappdoctor.repository.FiltracionRepository
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.MaterialAutoCompleteTextView

class ActionBtnSheetFragment : BottomSheetDialogFragment() {//, View.OnClickListener

    // private var mListener: itemClckSheetListenr? = null
     private lateinit var filVM: FiltracionViewModel
    private lateinit var sharedViewModel: SharVModel

    companion object {
        fun newInstance(
            dataListSector: List<Parcelable>,
            dataListZona: List<Parcelable>
        ): ActionBtnSheetFragment {
            val fragment = ActionBtnSheetFragment()
            val args = Bundle()
            args.putParcelableArrayList("dataListSector", ArrayList(dataListSector))
            args.putParcelableArrayList("dataListZona", ArrayList(dataListZona))

            fragment.arguments = args
            return fragment
        }
    }


    private var _binding: FragmentBottomsheetlayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // sharedViewModel = SharedViewModel()
        _binding = FragmentBottomsheetlayoutBinding.inflate(inflater, container, false)

        dialog?.window?.findViewById<FrameLayout>(com.google.android.material.R.id.design_bottom_sheet)
            ?.apply {
                background = ContextCompat.getDrawable((requireContext()), R.drawable.dialogbkg)
            }


        val args = arguments
        if (args != null && args.containsKey("dataListSector") && args.containsKey("dataListZona")) {
            val dataList = args.getParcelableArrayList<Parcelable>("dataListSector")
            val dataListZona = args.getParcelableArrayList<Parcelable>("dataListZona")


            if (dataList != null && dataListZona != null) {

                val sectorNames = dataList.map { (it as ContentSectorCiudad).descripcion }
                val sectorAdapter =
                    ArrayAdapter(requireContext(), R.layout.style_string_dropmenu, sectorNames)
                binding.exposedDropdownSector.setAdapter(sectorAdapter)

                val zonaNames = dataListZona.map { (it as ContentZonaCiudad).descripcion }
                val zonaAdapter =
                    ArrayAdapter(requireContext(), R.layout.style_string_dropmenu, zonaNames)
                binding.exposedDropdownZona.setAdapter(zonaAdapter)


            }
        }

        val exposeDownZona = binding.exposedDropdownZona
        exposeDownZona.inputType = InputType.TYPE_NULL
        exposeDownZona.isFocusable = true

        val exposedDropdownMenu = binding.exposedDropdownSector
        exposedDropdownMenu.inputType = InputType.TYPE_NULL
        exposedDropdownMenu.isFocusable = true

        return binding.root
    }



     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         super.onViewCreated(view, savedInstanceState)

         filVM = FiltracionViewModel(FiltracionRepository())
         val repoFiltracion = FiltracionRepository()
         val vMFacotory = FiltracionVMFactory(repoFiltracion)
         filVM = ViewModelProvider(this,vMFacotory).get(FiltracionViewModel::class.java)

         filVM.filtracionVM(
             89,
             50,
             "",
             "",
             25,
             1
         )
         filVM.resultFiltracion.observe(viewLifecycleOwner, Observer {response->
             println("FILTRACION SUCCEFUL "+ response?.codigo)


         })
         sharedViewModel = ViewModelProvider(requireActivity()).get(SharVModel::class.java)

         /*
         sharedViewModel.showListEvent.observe(viewLifecycleOwner, Observer {
             // Cuando se presione el botón btnMostarLisDoc, se ejecutará esta parte del código
             // Puedes realizar cualquier acción necesaria aquí
             val sectorList = sharedViewModel.sectorCiudadList.value
             val zonaList = sharedViewModel.zonaCiudadList.value

             val sectorListSize = sectorList?.count() ?: 0

             println("TAMANQOO $sectorListSize")
             println("ACTIONFRGAment")

         })

          */

         binding.btnMostarLisDoc.setOnClickListener {
             sharedViewModel.onShowListClick() // Notifica a través del ViewModel que se presionó el botón
             dismiss()
             println("FFSDSDSD "+ sharedViewModel.onShowListClick()  )
         }



     }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
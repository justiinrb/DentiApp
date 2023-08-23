package com.example.dentiappdoctor

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.PopupMenu
import android.widget.Toast
import com.example.dentiappdoctor.databinding.FragmentBottomsheetlayoutBinding
import com.example.dentiappdoctor.model.MZona_Ciudad.ContentZonaCiudad
import com.example.dentiappdoctor.model.ModelSectorC.ContentSectorCiudad
import com.example.dentiappdoctor.utils.ActionBtnSheetFragment
import com.google.android.material.textfield.TextInputLayout
import com.google.gson.Gson

 class Bottomsheetlayout: Fragment() {


    private var _binding: FragmentBottomsheetlayoutBinding? = null

    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentBottomsheetlayoutBinding.inflate(inflater, container, false)


        return binding.root
    }


     override fun onDestroyView() {
         super.onDestroyView()
         _binding = null
     }
 }

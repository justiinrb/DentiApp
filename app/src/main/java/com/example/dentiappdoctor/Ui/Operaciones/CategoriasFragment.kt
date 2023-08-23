package com.example.dentiappdoctor.Ui.Operaciones

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.dentiappdoctor.R
import com.example.dentiappdoctor.Ui.MenuActivity


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


class CategoriasFragment : Fragment() {

   // private lateinit var btnsht : Button
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
        return inflater.inflate(R.layout.fragment_categorias, container, false)
    }
/*
    override fun onCreateOptionsMenu(menu: Menu,inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.operaciones_drawer,menu)

        val activityM = requireActivity() as MenuActivity

        activityM.btn_sheet.visibility = View.GONE

    }
    */

}
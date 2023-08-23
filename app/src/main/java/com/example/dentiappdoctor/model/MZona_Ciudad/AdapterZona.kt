package com.example.dentiappdoctor.model.MZona_Ciudad

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dentiappdoctor.R

class AdapterZona(context: Context, private var contentZona:List<ContentZonaCiudad>):ArrayAdapter<ContentZonaCiudad>(context, R.layout.style_string_dropmenu, contentZona) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.style_string_dropmenu, parent, false)

        val dropMenuText: TextView = itemView.findViewById(R.id.dropMenu)
        val currentItem = getItem(position)
        dropMenuText.text = currentItem?.descripcion ?: ""

        return itemView
    }


}
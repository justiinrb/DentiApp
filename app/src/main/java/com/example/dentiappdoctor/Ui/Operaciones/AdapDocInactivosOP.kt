package com.example.dentiappdoctor.Ui.Operaciones

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dentiappdoctor.R
import com.example.dentiappdoctor.model.ModInactivosOP.DoctoresInactivosOP

class AdapDocInactivosOP(context: Context, private var InactivosContent: List<DoctoresInactivosOP>):RecyclerView.Adapter<AdapDocInactivosOP.MyViewHolder>() {

    private var filteredData = InactivosContent.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_users, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currenItem = InactivosContent[position]
        holder.nombreDoc.text = currenItem.nombre
        holder.correoDoc.text = currenItem.correo
        holder.cedulaDoc.text = currenItem.identificacion
    }

    override fun getItemCount() = InactivosContent.size


    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val nombreDoc: TextView = itemView.findViewById(R.id.NombresDoctor)

        val correoDoc: TextView = itemView.findViewById(R.id.correoDoctor)

        val cedulaDoc: TextView = itemView.findViewById(R.id.cedulaDoctor)
    }
}
package com.example.dentiappdoctor.Ui.Operaciones

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dentiappdoctor.R
import com.example.dentiappdoctor.model.MdoctorObtiene.DoctoresActivos

class AdapterDoctores(context: Context,private var  contentDoctor:List<DoctoresActivos>):
    RecyclerView.Adapter<AdapterDoctores.ViewHolder>(){//

    private var filteredContentDoctor: List<DoctoresActivos> = contentDoctor

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_users, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = contentDoctor.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currenItem = contentDoctor[position]
        holder.nombreDoc.text = currenItem.nombre
        holder.correoDoc.text = currenItem.correo
        holder.cedulaDoc.text = currenItem.identificacion
    }



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nombreDoc: TextView = itemView.findViewById(R.id.NombresDoctor)

        val correoDoc: TextView = itemView.findViewById(R.id.correoDoctor)

        val cedulaDoc: TextView = itemView.findViewById(R.id.cedulaDoctor)

    }
}


/*

 override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filteredList = mutableListOf<Doctore>()

                if (constraint.isNullOrEmpty()) {
                    filteredList.addAll(contentDoctor)
                } else {
                    val filterPattern = constraint.toString().toLowerCase().trim()

                    for (doctor in contentDoctor) {
                        if (doctor.nombre.toLowerCase().contains(filterPattern)||
                            doctor.sectorDescripcion.toLowerCase().contains(filterPattern) ||
                            doctor.zonaDescripcion.toLowerCase().contains(filterPattern)
                        ) {
                            filteredList.add(doctor)
                        }
                    }
                }
                val filterResults = FilterResults()
                filterResults.values = filteredList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                listaFiltrada.clear()
                listaFiltrada.addAll(results?.values as List<Doctore>)
                notifyDataSetChanged()
            }
        }
    }
    fun updateList(newList: List<Doctore>) {
        listaFiltrada.clear()
        listaFiltrada.addAll(newList)
        notifyDataSetChanged()
    }
 */
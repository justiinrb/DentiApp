package com.example.dentiappdoctor

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.dentiappdoctor.Ui.SesionActivity
import com.example.dentiappdoctor.databinding.FragmentPerfilBinding
import com.example.dentiappdoctor.model.Model_Conf_Login.ContentVerify
import com.google.gson.Gson

class PerfilFragment : Fragment() {


    //private lateinit var getMyclass : getMyclass
    private var _binding: FragmentPerfilBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
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

        _binding = FragmentPerfilBinding.inflate(inflater, container, false)
        getDat()

        val text =binding.root.findViewById<TextView>(R.id.cerrarSesion)
        text.setOnClickListener {
            showConfirmationDialog()

        }

        return binding.root

    }


    fun clearSharedPreferences(context: Context) {
        val sharedPreferences = context.getSharedPreferences("Myprefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()


    }
    private fun showConfirmationDialog(){

        val builder = AlertDialog.Builder(requireContext())//,R.style.AlertDialogCustom
       // builder.setTitle("Confirmacion")
        builder.setMessage("Cerrar la sesion de tu cuenta?")
        builder.setPositiveButton("Si"){dialog , which->
            clearSharedPreferences(requireContext())
            val i = Intent(requireContext(),SesionActivity::class.java)
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(i)
            requireActivity().finish()

        }
        builder.setNegativeButton("Cancelar",null)

        val dialog = builder.create()
        dialog.show()

    }



    fun getMyclass(context: Context): ContentVerify? {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences("Myprefs", Context.MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("verifyMyclass", null)
        return gson.fromJson(json, ContentVerify::class.java)
    }


    @SuppressLint("SetTextI18n")
    private fun getDat(){


        var status = ""

        val myCLass = getMyclass(requireContext())
        binding.nombrePrinc.text = myCLass?.nombres
        binding.apellidoPrinc.text = myCLass?.apellidos
        binding.rolAdmini.text = myCLass?.rolDescripcion
        binding.ubi.text = myCLass?.direccion
        binding.joined.text = myCLass?.fechaNacimiento


        binding.nombres.text = myCLass?.nombres
        binding.apellido.text = myCLass?.apellidos
        binding.identification.text = myCLass?.identificacion
        binding.birth.text = myCLass?.fechaNacimiento
        binding.codEmployee.text = myCLass?.codigoEmpleado

        status = if (myCLass?.status == true) "Activo" else "Inactivo"
        binding.status.text = status
        binding.Rol.text = myCLass?.rolDescripcion
        binding.numCell.text = myCLass?.celular
        binding.Email.text = myCLass?.correo
        binding.direccion.text = myCLass?.direccion

        if(myCLass!=null){
            val sucursales = myCLass.sucursales
            if(sucursales.isNotEmpty()){

                val primeraSucursal = sucursales[0]
                val nombreSucursal = primeraSucursal.nombre
                val referencia = primeraSucursal.referencia

                binding.sucNombre.text = nombreSucursal
                binding.referenciaList.text = referencia
            }

        }

    }
}
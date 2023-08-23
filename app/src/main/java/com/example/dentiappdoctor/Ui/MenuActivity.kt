package com.example.dentiappdoctor.Ui

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.os.Parcelable
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.dentiappdoctor.PerfilFragment
import com.example.dentiappdoctor.R
import com.example.dentiappdoctor.Ui.Cajeros.DashboardFragment
import com.example.dentiappdoctor.Ui.Cajeros.OrdenesFactFragment
import com.example.dentiappdoctor.Ui.Cajeros.OrdenesPenFragment
import com.example.dentiappdoctor.Ui.Operaciones.CategoriasFragment
import com.example.dentiappdoctor.Ui.Operaciones.DoctoresFragment
import com.example.dentiappdoctor.Ui.Operaciones.ServiciosFragment
import com.example.dentiappdoctor.Ui.Operaciones.SucursalesFragment
import com.example.dentiappdoctor.Ui.VsMedico.VisitadorMFragment
import com.example.dentiappdoctor.Ui.VsMedico.VsActivosFragment
import com.example.dentiappdoctor.Ui.VsMedico.VsInactivosFragment
import com.example.dentiappdoctor.Ui.VsMedico.VsNuevoFragment

import com.example.dentiappdoctor.databinding.ActivityMenuBinding
import com.example.dentiappdoctor.model.MZona_Ciudad.ContentZonaCiudad
import com.example.dentiappdoctor.model.ModelSectorC.ContentSectorCiudad
import com.example.dentiappdoctor.model.Model_Conf_Login.ContentVerify
import com.example.dentiappdoctor.utils.ActionBtnSheetFragment

import com.google.gson.Gson






class MenuActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
    DoctoresFragment.OnDataSendListener, DoctoresFragment.OnDataZonaListener{ //,itemClckSheetListenr

    private lateinit var binding: ActivityMenuBinding
    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var navigationView: NavigationView

    private lateinit var btnsht : Button

    private  var sectorList:List<ContentSectorCiudad> = emptyList()
    private  var zonaList:List<ContentZonaCiudad> = emptyList()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_drawer)
        setSupportActionBar(toolbar)
        sectorList = listOf()
        zonaList = listOf()

        val btnSheet = ActionBtnSheetFragment()



        //bottomSheetLayout = Bottomsheetlayout.newIntance(sectorList)
        //bottomSheetLayout = Bottomsheetlayout.Instance(zonaList)
        println("jjjjjjjj$sectorList")
        btnsht = toolbar.findViewById(R.id.btn_sheet)
        btnsht.visibility = View.GONE

        drawer = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
        toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close)
        drawer.addDrawerListener(toggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        //sharedViewModel = SharedViewModel()
        replaceFragment(CategoriasFragment())
        showMenuBasedOnRole()

    }
    fun getMyclass(context: Context): ContentVerify? {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences("Myprefs", Context.MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("verifyMyclass", null)
        return gson.fromJson(json, ContentVerify::class.java)
    }


    private fun showMenuBasedOnRole() {
        val myClass = getMyclass(this)
        navigationView.menu.clear()

        when (myClass?.rolDescripcion) {
            "Cajero" -> {
                navigationView.inflateMenu(R.menu.drawer_cajero)
                replaceFragment(DashboardFragment())
                println("El usuario es " + myClass.rolDescripcion)
            }

            "Operaciones" -> {
                navigationView.inflateMenu(R.menu.operaciones_drawer)
                replaceFragment(CategoriasFragment())
                println("El usuario es " + myClass.rolDescripcion)
            }

            "Visitador Médico" -> {
                navigationView.inflateMenu(R.menu.menu_doctores)
                replaceFragment(VisitadorMFragment())

            }
        }

        val headerView = navigationView.getHeaderView(0)
        val usernameText = headerView.findViewById<TextView>(R.id.nom_usuario)
        usernameText.text = myClass?.nombres
        val rolDescription = headerView.findViewById<TextView>(R.id.rol_description)
        rolDescription.text = myClass?.rolDescripcion

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        //if(item.groupId==R.id.header_mn){ return true
        item.isChecked = false
        when (item.itemId) {


            R.id.nav_dashboard -> {
                replaceFragment(DashboardFragment())
                return true
            }

            R.id.nav_ordenesPend -> {
                replaceFragment(OrdenesPenFragment())
                return true
            }

            R.id.nav_ordenesF -> {
                replaceFragment(OrdenesFactFragment())
                return true
            }
            R.id.perfilCajero->{
                replaceFragment(PerfilFragment())
                return true
            }
            // Agregar más casos según los elementos del menú
            R.id.nav_categorias -> {
                btnsht.visibility = View.GONE
                replaceFragment(CategoriasFragment())
                return true
            }

            R.id.nav_servicios -> {
                btnsht.visibility = View.GONE
                replaceFragment(ServiciosFragment())
                return true
            }

            R.id.nav_sucursales -> {
                btnsht.visibility = View.GONE
                replaceFragment(SucursalesFragment())
                return true
            }

            R.id.nav_doctores -> {
                btnsht.visibility = View.VISIBLE
                btnsht.setOnClickListener {

                    mostrarBotomSheet( sectorList,zonaList)


                }

                val doctor = DoctoresFragment()
                doctor.setOnDataSendListener(this)
                doctor.setOnDataZonaList(this)

                replaceFragment(doctor)



                return true
            }
            R.id.perfilOperaciones->{
                btnsht.visibility = View.GONE
                replaceFragment(PerfilFragment())
                return true
            }

            R.id.visitador_medico -> {
                replaceFragment(VisitadorMFragment())
                return true
            }

            R.id.vs_Nuevo -> {
                replaceFragment(VsNuevoFragment())
                return true
            }

            R.id.vs_Activos -> {
                replaceFragment(VsActivosFragment())
                return true
            }

            R.id.vs_Inactivos -> {
                replaceFragment(VsInactivosFragment())
                return true
            }
            R.id.perfilDoctores->{
                btnsht.visibility = View.GONE
                replaceFragment(PerfilFragment())
                return true
            }

            // Agregar más casos según los elementos del menú

        }
        println("categorias"+ R.id.nav_categorias)
        // navigationView.setNavigationItemSelectedListener(this)
        // navigationView.invalidate()
        //drawer.closeDrawer(GravityCompat.START)
        return false
    }


    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        drawer.closeDrawer(GravityCompat.START)
        fragmentTransaction.commit()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onDataSend(data: List<ContentSectorCiudad>?) {

        if(data!=null){
            sectorList = data
            println("DataList "+data.count())
        }else{
            println("No informacion")
        }
    }

    override fun onDataZona(listZona: List<ContentZonaCiudad>?) {
        if(listZona!= null ){
            zonaList = listZona
            println("ZonaLisst "+listZona.count())
        }else{
            println("Ninguna Zona ")
        }
    }

    private fun mostrarBotomSheet(dataListSector: List<Parcelable>,dataListZona: List<Parcelable>) {
        val botomSheet = ActionBtnSheetFragment.newInstance( dataListSector,dataListZona)
        botomSheet.show(supportFragmentManager, botomSheet.tag)
    }



    /*
        private var bottomSheetFragment: ActionBtnSheetFragment? = null
        fun mostrarBotomSheet(type: ActionBtnSheetFragment.BottomSheetType) {

            if(bottomSheetFragment==null || !bottomSheetFragment!!.isAdded) {
                val dataList = when (type){
                    ActionBtnSheetFragment.BottomSheetType.SECTOR_LIST -> sectorList
                    ActionBtnSheetFragment.BottomSheetType.ZONA_LIST -> zonaList
                }
                bottomSheetFragment = ActionBtnSheetFragment.newInstance(type, dataList)
                bottomSheetFragment?.show(supportFragmentManager, bottomSheetFragment?.tag)

            }

        }

     */






}
package com.example.dentiappdoctor.model.Model_Conf_Login


import com.google.gson.annotations.SerializedName

data class ContentVerify(
    @SerializedName("apellidos")
    val apellidos: String,
    @SerializedName("celular")
    val celular: String,
    @SerializedName("codigo_empleado")
    val codigoEmpleado: String,
    @SerializedName("correo")
    val correo: String,
    @SerializedName("direccion")
    val direccion: String,
    @SerializedName("doctor_sucursal")
    val doctorSucursal: DoctorSucursal,
    @SerializedName("fecha_creacion")
    val fechaCreacion: String,
    @SerializedName("fecha_nacimiento")
    val fechaNacimiento: String,
    @SerializedName("genero_descripcion")
    val generoDescripcion: String,
    @SerializedName("genero_id")
    val generoId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("identificacion")
    val identificacion: String,
    @SerializedName("nombres")
    val nombres: String,
    @SerializedName("rol_descripcion")
    val rolDescripcion: String,
    @SerializedName("rol_id")
    val rolId: Int,
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("sucursal_usuario_factura")
    val sucursalUsuarioFactura: List<SucursalUsuarioFactura>,
    @SerializedName("sucursales")
    val sucursales: List<Sucursale>,
    @SerializedName("tipo_identificacion_descripcion")
    val tipoIdentificacionDescripcion: String,
    @SerializedName("tipo_identificacion_id")
    val tipoIdentificacionId: Int,
    @SerializedName("token")
    val token: String,
    @SerializedName("visitador_sucursal")
    val visitadorSucursal: VisitadorSucursal
)
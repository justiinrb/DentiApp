package com.example.dentiappdoctor.model.ModelSectorC


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ContentSectorCiudad(
    @SerializedName("descripcion")
    val descripcion: String?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("valordouble1")
    val valordouble1: Int,
    @SerializedName("valordouble2")
    val valordouble2: Int,
    @SerializedName("valordouble3")
    val valordouble3: Int,
    @SerializedName("valorint1")
    val valorint1: Int,
    @SerializedName("valorint2")
    val valorint2: Int,
    @SerializedName("valorint3")
    val valorint3: Int
):Serializable, Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<ContentSectorCiudad> {
        override fun createFromParcel(parcel: Parcel): ContentSectorCiudad {
            return ContentSectorCiudad(parcel)
        }

        override fun newArray(size: Int): Array<ContentSectorCiudad?> {
            return arrayOfNulls(size)
        }
    }
}

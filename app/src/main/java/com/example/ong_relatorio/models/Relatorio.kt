package com.example.ong_relatorio.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Relatorio(
    @SerializedName("id") val id: String,
    @SerializedName("local") val local: String,
    @SerializedName("ph") val ph: Double,
    @SerializedName("cor") val cor: String,
    @SerializedName("odor") val odor: String,
    @SerializedName("coliformesTotais") val coliformesTotais: String,
    @SerializedName("eColi") val eColi: String,
    @SerializedName("Data") val data: String,
    @SerializedName("tempMin") val temperaturaMin: Double,
    @SerializedName("tempMax") val temperaturaMax: Double
):Serializable

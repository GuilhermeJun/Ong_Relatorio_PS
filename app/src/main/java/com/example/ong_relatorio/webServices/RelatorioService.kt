package com.example.ong_relatorio.webServices

import com.example.ong_relatorio.models.Relatorio
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RelatorioService {
    @GET("relatorios.json")
    fun getRelatorio(): Call<List<Relatorio>>
}

class RelatorioConnection {
    private val retrofit = Retrofit.Builder().baseUrl("https://chapa-virtual.web.app/").addConverterFactory(GsonConverterFactory.create()).build()
    val RelatorioServices = retrofit.create(RelatorioService::class.java)
}
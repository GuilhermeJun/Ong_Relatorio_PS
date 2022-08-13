package com.example.ong_relatorio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ong_relatorio.databinding.ActivityResultDetalhesBinding
import com.example.ong_relatorio.models.Relatorio

class ResultDetalhesActivity : AppCompatActivity() {

    lateinit var binding: ActivityResultDetalhesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultDetalhesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val relatorio = intent.extras?.get("relatorio")!! as Relatorio

        binding.tvResultLocal.text = relatorio.local
        binding.tvResultPh.text = relatorio.ph.toString()
        binding.tvResultCor.text = relatorio.cor
        binding.tvResultOdor.text = relatorio.odor
        binding.tvResultColiformesTotais.text = relatorio.coliformesTotais
        binding.tvResultEColi.text = relatorio.eColi
        binding.tvResultData.text = relatorio.data
        binding.tvResultTempMax.text = relatorio.temperaturaMax.toString()
        binding.tvResultTempMin.text = relatorio.temperaturaMin.toString()
    }
}
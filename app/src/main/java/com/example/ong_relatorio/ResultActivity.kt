package com.example.ong_relatorio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.ong_relatorio.adapter.RelatorioAdapter
import com.example.ong_relatorio.databinding.ActivityResultBinding
import com.example.ong_relatorio.models.Relatorio
import com.example.ong_relatorio.webServices.RelatorioConnection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultActivity : AppCompatActivity() {

    lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listaRelatorios()

    }

    private fun listaRelatorios() {
        val connection = RelatorioConnection()

        binding.pbLoading.visibility = View.VISIBLE
        binding.rvRelatorio.visibility = View.INVISIBLE

        connection.RelatorioServices.getRelatorio().enqueue(object: Callback<List<Relatorio>> {

            override fun onFailure(call: Call<List<Relatorio>>, t: Throwable) {
                binding.pbLoading.visibility = View.INVISIBLE
                Toast.makeText(this@ResultActivity, "Erro!", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<Relatorio>>, response: Response<List<Relatorio>>) {
                binding.pbLoading.visibility = View.INVISIBLE
                binding.rvRelatorio.visibility = View.VISIBLE

                val relatorios = response.body()

                relatorios?.let {
                    fillList(relatorios)
                } ?: run {
                    Toast.makeText(this@ResultActivity, "Erro!", Toast.LENGTH_LONG).show()
                }
            }
        })
    }
    private fun fillList(relatorios: List<Relatorio>) {
        val adapter = RelatorioAdapter(relatorios)
        binding.rvRelatorio.adapter = adapter
    }
}
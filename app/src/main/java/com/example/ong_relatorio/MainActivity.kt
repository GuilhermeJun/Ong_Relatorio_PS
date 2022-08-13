package com.example.ong_relatorio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ong_relatorio.databinding.ActivityMainBinding
import com.example.ong_relatorio.models.Relatorio
import com.example.ong_relatorio.webServices.RelatorioConnection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btConsultar.setOnClickListener {
            val intent = Intent(this@MainActivity, ResultActivity::class.java)
            startActivity(intent)
        }

        binding.btIntegrantes.setOnClickListener {
            val intent = Intent(this@MainActivity, IntegrantesActivity::class.java)
            startActivity(intent)
        }
    }
}

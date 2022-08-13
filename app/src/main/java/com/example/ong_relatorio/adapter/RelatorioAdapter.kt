package com.example.ong_relatorio.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ong_relatorio.R
import com.example.ong_relatorio.ResultDetalhesActivity
import com.example.ong_relatorio.models.Relatorio

class RelatorioAdapter(private val relatorios: List<Relatorio>) : RecyclerView.Adapter<RelatorioAdapter.RelatorioViewHolder>() {

    class RelatorioViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val tvResultLocal by lazy {
            view.findViewById<TextView>(R.id.tvResultLocal)
        }
        private val tvResultPh by lazy {
            view.findViewById<TextView>(R.id.tvResultPh)
        }

        fun bind(relatorio : Relatorio) {
            tvResultLocal.text = relatorio.local
            tvResultPh.text = relatorio.ph.toString()

            view.setOnClickListener {
                val intent = Intent(view.context, ResultDetalhesActivity::class.java)
                intent.putExtra("relatorio", relatorio)
                view.context.startActivity(intent)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RelatorioViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.result_relatorio, parent, false)
        return RelatorioViewHolder(view)
    }

    override fun getItemCount() = relatorios.size

    override fun onBindViewHolder(holder: RelatorioViewHolder, position: Int) {
        holder.bind(relatorios[position])
    }
}
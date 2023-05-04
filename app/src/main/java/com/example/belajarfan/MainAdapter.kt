package com.example.belajarfan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.belajarfan.databinding.ActivityGetBinding
import com.example.belajarfan.databinding.ListItemGetBinding

class MainAdapter (private val modelDosen: List<ModelDosen>):RecyclerView.Adapter<MainAdapter.ViewHolder>(){

    private lateinit var binding: ListItemGetBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_get,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder:ViewHolder,pos:Int){
        val data = modelDosen[pos]

        binding.txtID.text = data.nid.toString()

        binding.txtNama.text = data.name
        binding.txtTelepon.text = data.telepon
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
           return modelDosen.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var nama:TextView
        var nid:TextView
        var telepon:TextView
       init {
           nama = itemView.findViewById(R.id.txtID)
           nid = itemView.findViewById(R.id.nid)
           telepon = itemView.findViewById(R.id.telepon)


       }

    }
}
package com.example.belajarfan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.example.belajarfan.databinding.ActivityGetBinding
import com.example.belajarfan.databinding.ListItemGetBinding
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


class Get : AppCompatActivity() {
    private lateinit var binding: ActivityGetBinding
    private lateinit var binding1: ListItemGetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        getData()
      //  getNews()
    }

    /*private fun getNews() {

        val baseUrl = "https://api.nesabatechno.com/Presensi/laporan/nik/3515041008910004"
        AndroidNetworking.get(baseUrl)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponseBerhasil", response.toString())

                }

                override fun onError(e: ANError) {
                    Log.d("ErrorAwal",""+e.getErrorBody());
                    //Toast.makeText(this@Dashboard, "Tutup Kemudian Buka Kembali E-Presensi", Toast.LENGTH_SHORT).show()
                }

            })
    }*/



    private fun getData() {


        AndroidNetworking.get("https://10.0.105.145:45458/api/dosens/1")
            .setPriority(Priority.LOW)
            .build()
            .getAsJSONArray( object :JSONArrayRequestListener
            {

                override fun onResponse (response : JSONArray){

                    Log.e("_kotlinResponseBerhasil", response.toString())

                       // val jsonArray = response.getJSONArray("result")
                        for (i in 0 until response.length()) {
                            try {


                                binding1.txtID.setText(response.getString(0))
                                binding1.txtNama.setText(response.getString(1))
                                binding1.txtTelepon.setText(response.getString(2))
1
                            } catch(e: JSONException) {

                            }


                        }

                }

                override fun onError(e: ANError) {
                    Log.d("ErrorAwal",""+e.getErrorBody());
                    Toast.makeText(applicationContext, "Data gagal disimpan", Toast.LENGTH_SHORT).show()
                }

            })

    }

    private val data: Unit private get() {


    }
}
package com.example.belajarfan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.example.belajarfan.databinding.ActivityGetBinding
import org.json.JSONException
import org.json.JSONObject


class Get : AppCompatActivity() {
    private lateinit var binding: ActivityGetBinding

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
        AndroidNetworking.get("https://10.10.0.3:45456/api/dosens/1")
            .setPriority(Priority.LOW)
            .build()
            .getAsJSONObject(object: JSONObjectRequestListener
            {

                override fun onResponse (response : JSONObject){

                    Log.e("_kotlinResponseBerhasil", response.toString())
                    try {
                        val jsonArray = response.getJSONArray("result")
                        for (i in 0 until jsonArray.length()) {

                        }


                        binding.txtID.setText(response.getString("name"))
                        binding.txtNama.setText(response.getString("nid"))
                        binding.txtTelepon.setText(response.getString("nid"))

                    }catch(e: JSONException){
                        e.printStackTrace()
                    }
                }

                override fun onError(anError: ANError?) {
                    Toast.makeText(applicationContext, "Data gagal disimpan", Toast.LENGTH_SHORT).show()
                }

            })

    }
}
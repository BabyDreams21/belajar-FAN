package com.example.belajarfan

import android.os.Bundle
import android.renderscript.RenderScript.Priority
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.example.belajarfan.databinding.ActivityMainBinding
import org.json.JSONException
import org.json.JSONObject
import java.util.function.ToIntBiFunction


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnsimpan.setOnClickListener {
            AksiSimpan()
        }

        getData()

    }

    private fun getData() {

    }

    fun simpanData(view: View) {
        AksiSimpan()
    }
    fun AksiSimpan(){
        val txtNid = binding.nid.text.toString()
        val txtnama = binding.nid.text.toString()
        val txtTelepon = binding.nid.text.toString()

        if(txtNid.isEmpty()||txtnama.isEmpty()||txtTelepon.isEmpty()){

            Toast.makeText(this,"Data tidak boleh kosong",Toast.LENGTH_SHORT).show();

        }else
        {
            AndroidNetworking.post("https://localhost:44345/api/dosens")
                .addBodyParameter("nid", txtNid)
                .addBodyParameter("nama", txtnama)
                .addBodyParameter("telepon", txtTelepon)
                .setTag("test")
                .setPriority(com.androidnetworking.common.Priority.MEDIUM)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener
                {
                    override fun onResponse(response: JSONObject) {
                        try {
                            if (response.getString("Status").equals("Data berhasil tersimpan")) {
                                Toast.makeText(
                                    applicationContext,
                                    "Data berhasil tersimpan",
                                    Toast.LENGTH_LONG
                                ).show();
                            } else {
                                Toast.makeText(
                                    applicationContext,
                                    "Data gagal tersimpan",
                                    Toast.LENGTH_SHORT
                                ).show();
                            }

                        }catch(e:JSONException){
                            Toast.makeText(applicationContext,"Data gagal tersimpan",Toast.LENGTH_LONG).show()
                        }



                    }

                    override fun onError(anError: ANError?) {
                        Toast.makeText(applicationContext, "Data gagal disimpan", Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }
}






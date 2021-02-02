package com.example.saretrofitproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonShow.setOnClickListener {

            var makecall = RetrofitClient.myretrofit.getUsers()

            makecall.enqueue(object : Callback<List<UsersData>>{
                override fun onResponse(
                    call: Call<List<UsersData>>,
                    response: Response<List<UsersData>>
                ) {
                   var users : List<UsersData> = response.body()!!
                    var stringBuild = StringBuilder()

                    if(users!=null){

                        for(i in users){
                            stringBuild.append(i.name)
                            stringBuild.append("\n")

                            stringBuild.append(i.username)
                            stringBuild.append("\n")

                            stringBuild.append(i.email)
                            stringBuild.append("\n")
                            stringBuild.append("\n")

                        }
                    }

                    textViewResult.setText(stringBuild)
                }

                override fun onFailure(call: Call<List<UsersData>>, t: Throwable) {
                    Log.i("mytag", "ERROR IS :" + t.message)
                }

            })

        }

    }
}
package com.example.gympti.login.Fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.gympti.R
import com.example.gympti.StartFragment
import com.example.gympti.signup.Fragment.JoinIdFragment
import com.example.gympti.login.Fragment.LoginFragment as LoginFragment1


class LoginFragment : AppCompatActivity() {

    companion object{
        var requestQueue: RequestQueue?=null //여기!
    }



    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.fragment_login)

        requestQueue= Volley.newRequestQueue(applicationContext)


        var loginBtn : Button =findViewById(R.id.loginBtn)
        var idEdit : EditText = findViewById(R.id.loginIdEdit)
        var pwEdit : EditText = findViewById(R.id.loginPwEdit)
        var signUpBtn : Button = findViewById(R.id.signUpBtn)
        var findPwBtn : Button = findViewById(R.id.findPwBtn)

        loginBtn.setOnClickListener{

            val id = idEdit.text.toString().trim()
            val pw = pwEdit.text.toString().trim()

            //회원가입 때 받은 값 땡겨오기
//            val sharedPreference = getSharedPreferences("signUp", 0)
//            val haveID = sharedPreference.getString("id", "")
//            val havePw = sharedPreference.getString("pw", "")


            if (id.isEmpty() == true || pw.isEmpty() == true){
                Toast.makeText(applicationContext, "값을 입력해 주세요.", Toast.LENGTH_SHORT).show()
            }
            else {
                //입력 값이랑 회원가입 값이랑 비교
//                if (id == haveID && pw == havePw){
//                    Toast.makeText(applicationContext, "로그인 성공", Toast.LENGTH_SHORT).show()
//                    val intent = Intent(this, StartFragment::class.java)
//                    startActivity(intent)
//                }
//                else{;
//                    Toast.makeText(applicationContext, "다시 입력해주세요.", Toast.LENGTH_SHORT).show()
//                }
                Toast.makeText(applicationContext,id,Toast.LENGTH_SHORT).show()
                Toast.makeText(applicationContext,pw,Toast.LENGTH_SHORT).show()
            }

        }

        signUpBtn.setOnClickListener(){
//            val intent = Intent(this, JoinIdFragment::class.java)
//            startActivity(intent)
        }

    }

    fun send(){
        val request=object: StringRequest(
            Request.Method.GET,
            "http://10.10.10.10:8080/login",
            {
                "id=test"
            },
            {
                "pw=testpw"
            }

        ){
            override fun getParams():MutableMap<String,String>{
                val params=HashMap<String,String>()
                params["userid"]="john"

                return params
            }
        }

        request.setShouldCache(false)
        requestQueue?.add(request)
    }

}

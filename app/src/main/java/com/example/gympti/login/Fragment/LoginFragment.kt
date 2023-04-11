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
import com.example.gympti.R
import com.example.gympti.StartFragment
import com.example.gympti.signup.Fragment.JoinIdFragment
import com.example.gympti.login.Fragment.LoginFragment as LoginFragment1


class LoginFragment : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.fragment_login)


        var loginBtn : Button =findViewById(R.id.loginBtn)
        var idEdit : EditText = findViewById(R.id.loginIdEdit)
        var pwEdit : EditText = findViewById(R.id.loginPwEdit)
        var signUpBtn : Button = findViewById(R.id.signUpBtn)
        var findPwBtn : Button = findViewById(R.id.findPwBtn)

        loginBtn.setOnClickListener{

            val id = idEdit.text.toString().trim()
            val pw = pwEdit.text.toString().trim()

            //회원가입 때 받은 값 땡겨오기
            val sharedPreference = getSharedPreferences("signUp", Context.MODE_PRIVATE)
            val haveID = sharedPreference.getString("id", "")
            val havePw = sharedPreference.getString("pw", "")


            if (id.isEmpty() == true || pw.isEmpty() == true){
                Toast.makeText(applicationContext, "값을 입력해 주세요.", Toast.LENGTH_SHORT).show()
            }
            else {
                //입력 값이랑 회원가입 값이랑 비교
                if (id == haveID && pw == havePw){
                    Toast.makeText(applicationContext, "로그인 성공.", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, StartFragment::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(applicationContext, "다시 입력해주세요.", Toast.LENGTH_SHORT).show()
                }
            }

        }

        signUpBtn.setOnClickListener(){
            val intent = Intent(this, JoinIdFragment::class.java)
            startActivity(intent)
        }

    }
}




/*
* // 로그인 버튼
        btn_login.setOnClickListener {

            //editText로부터 입력된 값을 받아온다
            var id = edit_id.text.toString()
            var pw = edit_pw.text.toString()

            // 쉐어드로부터 저장된 id, pw 가져오기
            val sharedPreference = getSharedPreferences("file name", Context.MODE_PRIVATE)
            val savedId = sharedPreference.getString("id", "")
            val savedPw = sharedPreference.getString("pw", "")

            // 유저가 입력한 id, pw값과 쉐어드로 불러온 id, pw값 비교
            if(id == savedId && pw == savedPw){
                // 로그인 성공 다이얼로그 보여주기
                dialog("success")
            }
            else{
                // 로그인 실패 다이얼로그 보여주기
                dialog("fail")
            }
        }

        // 회원가입 버튼
        btn_register.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

    }
* */
package com.example.gympti.login.Fragment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gympti.R
import com.example.gympti.login.Fragment.LoginFragment as LoginFragment1


class LoginFragment : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)


        var loginBtn : Button =findViewById(R.id.loginBtn)
        var idEdit : EditText = findViewById(R.id.loginIdEdit)
        var pwEdit : EditText = findViewById(R.id.loginPwEdit)

        loginBtn.setOnClickListener{
            if (idEdit.isFocused() == true && pwEdit.isFocused() == true) {
                val id = idEdit.text.toString().trim()
                val pw = pwEdit.text.toString().trim()

//                val intent = Intent(this@LoginFragment,  ::class.java)
//                startFragment(intent)

                Toast.makeText(applicationContext, "로그인 성공", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
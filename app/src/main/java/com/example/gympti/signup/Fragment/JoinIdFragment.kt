package com.example.gympti.signup.Fragment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gympti.R
import com.example.gympti.login.Fragment.LoginFragment

class JoinIdFragment  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_join_id)

        var joinIdBtn: Button = findViewById(R.id.joinIdBtn)
        var idEdit: EditText = findViewById(R.id.joinIdMsg)
        var reBtn : Button = findViewById(R.id.JoinReBtnId)

        joinIdBtn.setOnClickListener {

            val id = idEdit.text.toString().trim()

            //값이 비었을때
            if (id.isEmpty() == true) {
                Toast.makeText(applicationContext, "입력해주세요.", Toast.LENGTH_SHORT).show()
            }
            else {
                val sharedPreference = getSharedPreferences("login", 0 ) //쉐어드 프리퍼런스 : 쉐어드 명 : 로그인 형태 : private
                val editor = sharedPreference.edit()
                editor.putString("id", id)
                editor.apply()

                Toast.makeText(applicationContext, "ID 성공", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, JoinPwFragment::class.java)
                startActivity(intent)
            }
        }

        reBtn.setOnClickListener(){
            val intent = Intent(this, LoginFragment::class.java)
            startActivity(intent)
        }

    }
}
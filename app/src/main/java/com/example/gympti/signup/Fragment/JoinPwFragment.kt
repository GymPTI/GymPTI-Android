package com.example.gympti.signup.Fragment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gympti.R

class JoinPwFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_join_pw)

        var joinPwBtn: Button = findViewById(R.id.joinPwBtn)
        var pwEdit: EditText = findViewById(R.id.joinPwMsg)
        var reBtn : Button = findViewById(R.id.JoinReBtnPw)

        joinPwBtn.setOnClickListener {

            val pw = pwEdit.text.toString().trim()

            //값이 비었을때
            if (pw.isEmpty() == true) {
                Toast.makeText(applicationContext, "입력해주세요.", Toast.LENGTH_SHORT).show()
            }
            else {
                val sharedPreference = getSharedPreferences("signUp", 0 ) //쉐어드 프리퍼런스 : 쉐어드 명 : 로그인 형태 : private
                val editor = sharedPreference.edit()
                editor.putString("pw", pw)
                editor.apply()

                Toast.makeText(applicationContext, "pw 성공", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, JoinNameFragment::class.java)
                startActivity(intent)
            }
        }

        reBtn.setOnClickListener(){
            val intent = Intent(this, JoinIdFragment::class.java)
            startActivity(intent)
        }

    }
}
package com.example.gympti.signup.Fragment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gympti.R
import com.example.gympti.StartFragment

class JoinEmailFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_join_email)

        var joinEmailBtn: Button = findViewById(R.id.joinEmailBtn)
        var emailEdit: EditText = findViewById(R.id.joinEmailMsg)
        var reBtn : Button = findViewById(R.id.JoinReBtnEmail)

        joinEmailBtn.setOnClickListener {

            val email = emailEdit.text.toString().trim()

            //값이 비었을때
            if (email.isEmpty() == true) {
                Toast.makeText(applicationContext, "입력해주세요.", Toast.LENGTH_SHORT).show()
            }
            else {
                val sharedPreference = getSharedPreferences("login", 0 ) //쉐어드 프리퍼런스 : 쉐어드 명 : 로그인 형태 : private
                val editor = sharedPreference.edit()
                editor.putString("email", email)
                editor.apply()

                Toast.makeText(applicationContext, "email 성공", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, StartFragment::class.java)
                startActivity(intent)
            }
        }

        reBtn.setOnClickListener(){
            val intent = Intent(this, JoinNameFragment::class.java)
            startActivity(intent)
        }
    }
}
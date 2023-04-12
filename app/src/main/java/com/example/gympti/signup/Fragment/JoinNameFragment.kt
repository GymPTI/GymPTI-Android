package com.example.gympti.signup.Fragment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gympti.R

class JoinNameFragment  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_join_name)

        var joinNameBtn: Button = findViewById(R.id.joinNameBtn)
        var nameEdit: EditText = findViewById(R.id.joinNameMsg)
        var reBtn : Button = findViewById(R.id.JoinReBtnName)

        joinNameBtn.setOnClickListener {

            val name = nameEdit.text.toString().trim()

            //값이 비었을때
            if (name.isEmpty() == true) {
                Toast.makeText(applicationContext, "입력해주세요.", Toast.LENGTH_SHORT).show()
            }
            else {
                val sharedPreference = getSharedPreferences("signUp", 0 ) //쉐어드 프리퍼런스 : 쉐어드 명 : 로그인 형태 : private
                val editor = sharedPreference.edit()
                editor.putString("name", name)
                editor.apply()

                Toast.makeText(applicationContext, "name 성공", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, JoinEmailFragment::class.java)
                startActivity(intent)
            }
        }

        reBtn.setOnClickListener(){
            val intent = Intent(this, JoinPwFragment::class.java)
            startActivity(intent)
        }
    }
}
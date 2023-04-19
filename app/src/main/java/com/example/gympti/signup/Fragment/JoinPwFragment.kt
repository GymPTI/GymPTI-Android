package com.example.gympti.signup.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.gympti.R
import com.example.gympti.databinding.FragmentJoinIdBinding
import com.example.gympti.databinding.FragmentJoinPwBinding

class JoinPwFragment : Fragment() {
    private var mBinding : FragmentJoinPwBinding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentJoinPwBinding.inflate(inflater, container, false)
        joinPw()
        returnView()
        return binding.root
    }

    private fun befoView() {

    }

    private fun joinPw() {
        binding.joinPwBtn.setOnClickListener {
            val pw = binding.joinPwMsg.text.toString().trim()

            if (pw.isEmpty() == true){
                Toast.makeText(context,"비밀번호 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
            else{
//                비밀 저장, 토스트 메세지 띄우고, 프래그먼트 전환
            }
        }
    }

    private fun returnView() {
        binding.JoinReBtnPw.setOnClickListener(){
//            이전 화면 전환
        }
    }


//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_join_pw)
//
//        var joinPwBtn: Button = findViewById(R.id.joinPwBtn)
//        var pwEdit: EditText = findViewById(R.id.joinPwMsg)
//        var reBtn : Button = findViewById(R.id.JoinReBtnPw)
//
//        joinPwBtn.setOnClickListener {
//
//            val pw = pwEdit.text.toString().trim()
//
//            //값이 비었을때
//            if (pw.isEmpty() == true) {
//                Toast.makeText(applicationContext, "입력해주세요.", Toast.LENGTH_SHORT).show()
//            }
//            else {
//                val sharedPreference = getSharedPreferences("signUp", 0 ) //쉐어드 프리퍼런스 : 쉐어드 명 : 로그인 형태 : private
//                val editor = sharedPreference.edit()
//                editor.putString("pw", pw)
//                editor.apply()
//
//                Toast.makeText(applicationContext, "pw 성공", Toast.LENGTH_SHORT).show()
//
//                val intent = Intent(this, JoinNameFragment::class.java)
//                startActivity(intent)
//            }
//        }
//
//        reBtn.setOnClickListener(){
//            val intent = Intent(this, JoinIdFragment::class.java)
//            startActivity(intent)
//        }
//
//    }
}
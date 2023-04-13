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
import com.example.gympti.databinding.FragmentLoginBinding
import com.example.gympti.login.Fragment.LoginFragment

class JoinIdFragment  : Fragment() {

    private var mBinding : FragmentJoinIdBinding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentJoinIdBinding.inflate(inflater, container, false)
        joinId()
        returnView()
        return binding.root
//        return super.onCreateView(inflater, container, savedInstanceState)
    }


    private fun joinId() {
        binding.joinIdBtn.setOnClickListener(){
            val id = binding.joinIdMsg.text.toString().trim()

            if(id.isEmpty() == true){
                Toast.makeText(context,"아이디를 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
            else{
//                아이디 입력 받고 토스트 띄우고 다음화면
            }
        }
    }

    private fun returnView() {
        binding.JoinReBtnId.setOnClickListener(){

        }
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_join_id)
//
//        var joinIdBtn: Button = findViewById(R.id.joinIdBtn)
//        var idEdit: EditText = findViewById(R.id.joinIdMsg)
//        var reBtn : Button = findViewById(R.id.JoinReBtnId)
//
//        joinIdBtn.setOnClickListener {
//
//            val id = idEdit.text.toString().trim()
//
//            //값이 비었을때
//            if (id.isEmpty() == true) {
//                Toast.makeText(applicationContext, "입력해주세요.", Toast.LENGTH_SHORT).show()
//            }
//            else {
//                val sharedPreference = getSharedPreferences("signUp", 0 ) //쉐어드 프리퍼런스 : 쉐어드 명 : 로그인 형태 : private
//                val editor = sharedPreference.edit()
//                editor.putString("id", id)
//                editor.apply()
//
//                Toast.makeText(applicationContext, "ID 성공", Toast.LENGTH_SHORT).show()
//
//                val intent = Intent(this, JoinPwFragment::class.java)
//                startActivity(intent)
//            }
//        }
//
//        reBtn.setOnClickListener(){
//            setContentView(R.layout.fragment_join_id)
//        }
//
//    }
}
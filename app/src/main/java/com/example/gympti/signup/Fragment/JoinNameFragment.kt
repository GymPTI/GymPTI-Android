package com.example.gympti.signup.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.gympti.R
import com.example.gympti.databinding.FragmentJoinNameBinding
import com.example.gympti.databinding.FragmentJoinPwBinding

class JoinNameFragment  : Fragment() {

    private var mBinding : FragmentJoinNameBinding? = null
    private val binding = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentJoinNameBinding.inflate(inflater, container, false)
        joinName()
        return binding.root
    }

    private fun joinName() {
        binding.joinNameBtn.setOnClickListener(){
            val name = binding.joinNameMsg.text.toString().trim()

            if(name.isEmpty() == true){
                Toast.makeText(context,"이름을 입력해주세요.",Toast.LENGTH_SHORT).show()
            }
            else{
//           이름 저장, 토스트 띄우고, 프래그먼트 넘겨줌
            }
        }
    }


//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_join_name)
//
//        var joinNameBtn: Button = findViewById(R.id.joinNameBtn)
//        var nameEdit: EditText = findViewById(R.id.joinNameMsg)
//        var reBtn : Button = findViewById(R.id.JoinReBtnName)
//
//        joinNameBtn.setOnClickListener {
//
//            val name = nameEdit.text.toString().trim()
//
//            //값이 비었을때
//            if (name.isEmpty() == true) {
//                Toast.makeText(applicationContext, "입력해주세요.", Toast.LENGTH_SHORT).show()
//            }
//            else {
//                val sharedPreference = getSharedPreferences("signUp", 0 ) //쉐어드 프리퍼런스 : 쉐어드 명 : 로그인 형태 : private
//                val editor = sharedPreference.edit()
//                editor.putString("name", name)
//                editor.apply()
//
//                Toast.makeText(applicationContext, "name 성공", Toast.LENGTH_SHORT).show()
//
//                val intent = Intent(this, JoinEmailFragment::class.java)
//                startActivity(intent)
//            }
//        }
//
//        reBtn.setOnClickListener(){
//            val intent = Intent(this, JoinPwFragment::class.java)
//            startActivity(intent)
//        }
//    }
}
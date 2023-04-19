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
import com.example.gympti.StartFragment
import com.example.gympti.databinding.FragmentJoinEmailBinding
import com.example.gympti.databinding.FragmentJoinIdBinding

class JoinEmailFragment : Fragment() {

    private var mBinding : FragmentJoinEmailBinding? = null
    private val binding = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentJoinEmailBinding.inflate(inflater,container,false)
        joinEmail()
        return binding.root
//        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private fun joinEmail() {
        binding.joinEmailBtn.setOnClickListener(){
            val email = binding.joinEmailMsg.text.toString().trim()

            if(email.isEmpty() == true){
                Toast.makeText(context,"이메일을 입력해주세요.",Toast.LENGTH_SHORT).show()
            }
            else{
//           이메일 확인 숫자 보내고, 입력칸 보여줌
            }
        }
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_join_email)
//
//        var joinEmailBtn: Button = findViewById(R.id.joinEmailBtn)
//        var emailEdit: EditText = findViewById(R.id.joinEmailMsg)
//        var reBtn : Button = findViewById(R.id.JoinReBtnEmail)
//        var Num : EditText = findViewById(R.id.joinEmailNum)
//
//
//
//        joinEmailBtn.setOnClickListener {
//
//
//            Num.setVisibility(View.INVISIBLE);
//
//            val email = emailEdit.text.toString().trim()
//
//            //값이 비었을 때
//            if (email.isEmpty() == true) {
//                Toast.makeText(applicationContext, "입력해주세요.", Toast.LENGTH_SHORT).show()
//            }
//            else {
//                val sharedPreference = getSharedPreferences("signUp", 0 ) //쉐어드 프리퍼런스 : 쉐어드 명 : 로그인 형태 : private
//                val editor = sharedPreference.edit()
//                editor.putString("email", email)
//                editor.apply()
//
//                Num.setVisibility(View.VISIBLE);
//
//            }
//        }
//
//        reBtn.setOnClickListener(){
//            val intent = Intent(this, JoinNameFragment::class.java)
//            startActivity(intent)
//        }
//    }
}
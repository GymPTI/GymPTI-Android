package com.example.gympti.login.Fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.JsonRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.gympti.R
import com.example.gympti.StartFragment
import com.example.gympti.databinding.ActivityMainBinding
import com.example.gympti.databinding.FragmentLoginBinding
import com.example.gympti.signup.Fragment.JoinIdFragment
import com.google.gson.JsonObject
import org.json.JSONException
import org.json.JSONObject
import com.example.gympti.login.Fragment.LoginFragment as LoginFragment1


class LoginFragment : Fragment() {

    private var mBinding: FragmentLoginBinding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentLoginBinding.inflate(inflater, container, false)
        init()
        joinView()
        return binding.root
//        return super.onCreateView(inflater, container, savedInstanceState)
    }



    private fun init() {
        requestQueue = Volley.newRequestQueue(context)
        binding.loginBtn.setOnClickListener{

            val id = binding.loginIdEdit.text.toString().trim()
            val pw = binding.loginPwEdit.text.toString().trim()
            send()

            //회원가입 때 받은 값 땡겨오기
//            val sharedPreference = getSharedPreferences("signUp", 0)
//            val haveID = sharedPreference.getString("id", "")
//            val havePw = sharedPreference.getString("pw", "")


            if (id.isEmpty() == true || pw.isEmpty() == true){
                Toast.makeText(context, "값을 입력해 주세요.", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(context,"id : " +id,Toast.LENGTH_SHORT).show()
                Toast.makeText(context,"pw : " +pw,Toast.LENGTH_SHORT).show()
            }

        }
    }
    private fun joinView() {
        binding.signUpBtn.setOnClickListener(){
// 프래그 먼트 바꿔줌

        }
    }

    companion object{
        var requestQueue: RequestQueue?=null //여기!
    }


    fun send() {

        var url = "http://veryhotseo81.duckdns.org:8888/gympti/auth/register"
        val email = binding.loginIdEdit.text.toString().trim()

        var sendData = JSONObject("{\"email\":\""+email + "\"}")

        sendData.put("userId", binding.loginIdEdit.text.toString().trim());
        sendData.put("userName", "홍길동");
        sendData.put("email", "jogayeon1214@naver.com");
        sendData.put("password", binding.loginPwEdit.text.toString().trim());


        Log.d("LoginFragment", "sendData"+sendData)
        val request = JsonObjectRequest(
            Request.Method.POST,
            url,
            sendData,
            Response.Listener{ response ->
                try{
                    Log.d("LoginFragment", response.toString());
            } catch (e: JSONException){
                e.printStackTrace()
            }
       }, Response.ErrorListener {  }
    )

        requestQueue?.add(request)
    }

}


//    override fun onCreate(savedInstanceState: Bundle?) {
//            super.onCreate(savedInstanceState)
//            setContentView(R.layout.fragment_login)
//
//        requestQueue= Volley.newRequestQueue(applicationContext)
//
//
//        var loginBtn : Button =findViewById(R.id.loginBtn)
//        var idEdit : EditText = findViewById(R.id.loginIdEdit)
//        var pwEdit : EditText = findViewById(R.id.loginPwEdit)
//        var signUpBtn : Button = findViewById(R.id.signUpBtn)
//        var findPwBtn : Button = findViewById(R.id.findPwBtn)
//
//        loginBtn.setOnClickListener{
//
//            val id = idEdit.text.toString().trim()
//            val pw = pwEdit.text.toString().trim()
//
//            //회원가입 때 받은 값 땡겨오기
////            val sharedPreference = getSharedPreferences("signUp", 0)
////            val haveID = sharedPreference.getString("id", "")
////            val havePw = sharedPreference.getString("pw", "")
//
//
//            if (id.isEmpty() == true || pw.isEmpty() == true){
//                Toast.makeText(applicationContext, "값을 입력해 주세요.", Toast.LENGTH_SHORT).show()
//            }
//            else {
//                //입력 값이랑 회원가입 값이랑 비교
////                if (id == haveID && pw == havePw){
////                    Toast.makeText(applicationContext, "로그인 성공", Toast.LENGTH_SHORT).show()
////                    val intent = Intent(this, StartFragment::class.java)
////                    startActivity(intent)
////                }
////                else{;
////                    Toast.makeText(applicationContext, "다시 입력해주세요.", Toast.LENGTH_SHORT).show()
////                }
//                Toast.makeText(applicationContext,id,Toast.LENGTH_SHORT).show()
//                Toast.makeText(applicationContext,pw,Toast.LENGTH_SHORT).show()
//            }
//
//        }
//
//        signUpBtn.setOnClickListener(){
////            val intent = Intent(this, JoinIdFragment::class.java)
////            startActivity(intent)
//        }
//
//    }

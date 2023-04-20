package com.example.gympti.login.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.gympti.databinding.FragmentLoginBinding
import org.json.JSONObject
import java.security.MessageDigest


class LoginFragment : Fragment() {

    private var mBinding: FragmentLoginBinding? = null
    private val binding get() = mBinding!!
    var user = Array<String>(2,{""})


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



            if (id.isEmpty() == true || pw.isEmpty() == true){
                Toast.makeText(context, "값을 입력해 주세요.", Toast.LENGTH_SHORT).show()
            }
            else {
                user[0]=id
                user[1]=pw
                send()
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

        var url = "http://veryhotseo81.duckdns.org:8888/gympti/auth/login"

        var sendData = JSONObject()
//
        sendData.put("userId",user[0]);
        sendData.put("password", user[1]);


        Log.d("LoginFragment", "sendData"+sendData)
        val request = JsonObjectRequest(
            Request.Method.POST,
            url,
            sendData,
            Response.Listener{ response ->
                Log.d("LoginFragment", response.toString());
       }, Response.ErrorListener {
                Log.d("LoginFragment", it.networkResponse.statusCode.toString())
                var body = String(it.networkResponse.data, Charsets.UTF_8)
                Log.d("LoginFragment", body)
//                응답에서 status 코드 내놔
            }
    )

        requestQueue?.add(request)
    }

//    private fun getSHA512(str: String): String {
//        var digest = MessageDigest.getInstance("SHA-512")
//        var sha512bytes = digest.digest(str.toByteArray(Charsets.UTF_8))
//
//        return getHexToString(sha512bytes)
//    }
//
//    private fun getHexToString(bArr : ByteArray) : String{
//
//        var str = ""
//        str = bArr.map { Integer.toHexString(0xFF and it.toInt()) }
//            .map { if (it.length<2) "0$it" else it}
//            .fold("",{acc, d-> acc+d})
//        return str.uppercase()
//
//
//    }

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

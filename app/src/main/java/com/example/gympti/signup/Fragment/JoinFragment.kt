package com.example.gympti.signup.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.gympti.databinding.FragmentJoinBinding
import com.example.gympti.login.Fragment.LoginFragment
import org.json.JSONObject
import java.security.MessageDigest

class JoinFragment : Fragment() {
    private var state = 0;
    private var mBinding: FragmentJoinBinding? = null
    private val binding get() = mBinding!!
    private var user = Array<String>(4, { "" })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentJoinBinding.inflate(inflater, container, false)
//        binding.
        join()
        backPage()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun backPage() {
        binding.backBtn.setOnClickListener() {

            if (state == 0) {
                //로그인
            } else {
                when (state) {
                    1 -> {
                        Id()
                        binding.input.setText(null)
                        --state
                    }
                    2 -> {
                        Pw()
                        binding.input.setText(null)
                        --state
                    }
                    3 -> {
                        Name()
                        binding.input.setText(null)
                        --state
                    }
                }
            }

        }
    }

    private fun join() {
        binding.nextBtn.setOnClickListener() {
            Log.d("Test", state.toString())
            when (state) {
                0 -> {
                    if (binding.input.text.isNullOrBlank()) {
                        Toast.makeText(context, "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show()
                    } else {
                        binding.input.setText(null)
                        state++
                        Pw()
                    }

                }
                1 -> {
                    if (binding.input.text.isNullOrBlank()) {
                        Toast.makeText(context, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
                    } else {
                        binding.input.setText(null)
                        state++
                        Name()
                    }
                }
                2 -> {
                    if (binding.input.text.isNullOrBlank()) {
                        Toast.makeText(context, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show()
                    } else {
                        binding.input.setText(null)
                        state++
                        Email()
                    }
                }
                3 -> {
                    if (binding.input.text.isNullOrBlank()) {
                        Toast.makeText(context, "이메일를 입력해주세요.", Toast.LENGTH_SHORT).show()
                    } else {
                        //회원가입
                        Toast.makeText(context, "회원가입 완료", Toast.LENGTH_SHORT).show()
                    }

                }
            }
        }
    }

    private fun Id() {

        var id = binding.input.text.toString().trim()


        binding.tv.text = "아이디"
        binding.input.setHint("아이디를 입력해주세요.")
        binding.tv2.text = "*4~20자의 영문 소/대문자를 입력해주세요"
        user[0] = id

    }

    private fun Pw() {

        var pw = getSHA512(binding.input.text.toString().trim())
        binding.tv.text = "비밀번호"
        binding.input.setHint("비밀번호를 입력해주세요.")
        binding.tv2.text = "*8~20자의 영문 소/대문자 또는 기호를 입력해주세요"
        user[1] = pw
    }

    private fun Name() {
        var name = binding.input.text.toString().trim()
        binding.tv.text = "이름"
        binding.input.setHint("이름을 입력해주세요.")
        binding.tv2.text = "*이름은 가입 후 바꾸실 수 있습니다."
        user[2] = name
    }

    private fun Email() {

        var email = binding.input.text.toString().trim()

        binding.tv.text = "이메일"
        binding.input.setHint("이메일을 입력해주세요.")
        binding.tv2.text = "*인증번호를 받으실 이메일을 입력해주세요."
        user[3] = email

        sendEmail()
        cheakEmail()
        register()


//                아이디 입력 받고, 중복확인, 토스트 띄우고 다음화면
    }


    companion object {
        var requestQueue: RequestQueue? = null

    }

    private fun sendEmail() {
        var url = "http://veryhotseo81.duckdns.org:8888/gympti/auth/sendMailVerification"
        var sendData = JSONObject()

        sendData.put("email", user[3])

        Log.d("PostEmail aljalddak", "sendData" + sendData)
        val request = JsonObjectRequest(
            Request.Method.POST,
            url,
            sendData,
            Response.Listener { response ->
                Log.d("JoinFragment", response.toString());
            }, Response.ErrorListener {
                Log.d("JoinFragment", it.networkResponse.statusCode.toString())
                var body = String(it.networkResponse.data, Charsets.UTF_8)
                Log.d("JoinFragment", body)
            }
        )

        LoginFragment.requestQueue?.add(request)

    }

    private fun cheakEmail() {
        var url = "http://veryhotseo81.duckdns.org:8888/gympti/auth/validateMailVerification"
        var sendData = JSONObject()

        sendData.put("email", user[3])
        sendData.put("emailVerificationCode", user[4])

        Log.d("PostEmail aljalddak", "sendData" + sendData)
        val request = JsonObjectRequest(
            Request.Method.POST,
            url,
            sendData,
            Response.Listener { response ->
                Log.d("JoinFragment", response.toString());
            }, Response.ErrorListener {
                Log.d("JoinFragment", it.networkResponse.statusCode.toString())
                var body = String(it.networkResponse.data, Charsets.UTF_8)
                Log.d("JoinFragment", body)
            }
        )

        LoginFragment.requestQueue?.add(request)

    }

    fun register() {
        var url = "http://veryhotseo81.duckdns.org:8888/gympti/auth/register"
        var sendData = JSONObject()

        sendData.put("userId", user[0]);
        sendData.put("userName", user[2]);
        sendData.put("email", user[3]);
        sendData.put("password", user[1]);


        Log.d("JoinFragment", "sendData" + sendData)

        val request = JsonObjectRequest(
            Request.Method.POST,
            url,
            sendData,
            Response.Listener { response ->
                Log.d("JoinFragment", response.toString());
            }, Response.ErrorListener {
                Log.d("JoinFragment", it.networkResponse.statusCode.toString())
                var body = String(it.networkResponse.data, Charsets.UTF_8)
                Log.d("JoinFragment", body)
            }
        )

        LoginFragment.requestQueue?.add(request)
    }

    private fun getSHA512(str: String): String {
        var digest = MessageDigest.getInstance("SHA-512")
        var sha512bytes = digest.digest(str.toByteArray(Charsets.UTF_8))

        //입력받은 str을 utf-8 형식으로 byte배열로 변환 digest에 담음 =>sha-512 암호화 방식으로 변환.

        return getHexToString(sha512bytes)
    }

    private fun getHexToString(bArr: ByteArray): String {

        var str = ""
        str = bArr.map { Integer.toHexString(0xFF and it.toInt()) }

            /*
              hex : 진수 변환
             .map : 반복문 처럼 요소를 하나하나 쪼개서 변수(=it)에 넣음.
              0xFF = 최대치 : int하면 int값 그대로.
            */

            .map { if (it.length < 2) "0$it" else it }
            .fold("", { acc, d -> acc + d })
        return str.uppercase()


    }

}
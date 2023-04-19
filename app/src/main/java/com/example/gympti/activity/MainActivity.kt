package com.example.gympti

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.gympti.databinding.ActivityMainBinding
import com.example.gympti.login.Fragment.LoginFragment

class MainActivity : AppCompatActivity() {

    private var mBinding:ActivityMainBinding? = null
    private val binding get() = mBinding!!

/*    전역변수 선언시 초기화 필수, 형태 선언 필수
    이름 명명 규칙 꼭 지켜야함. 이름 앞뒤로 바꿔서 하기 ex)MainActivity => ActivityMain
    mBinding 이라는 변수에 바인딩을 담을 공간을 만들어줌. -> binding 상수에 바인딩 부분만 담음
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setFragment()
//        바인딩에 액티비티 안에 든 값을 다 담음

    }

    private fun setFragment() {
        var trans = supportFragmentManager.beginTransaction()
//        프래그머먼트 관리 라이브러리 / 프래그먼트 설정 변수에 담기
        trans.add(R.id.frameLayout, LoginFragment())
        trans.addToBackStack(null)
        trans.commit()
//        이전화면 초기화

    }
}
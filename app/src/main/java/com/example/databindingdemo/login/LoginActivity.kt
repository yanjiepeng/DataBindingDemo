package com.example.databindingdemo.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.databindingdemo.R
import com.example.databindingdemo.databinding.ActivityLoginBinding
import com.example.databindingdemo.login.bean.UserBean

class LoginActivity : AppCompatActivity() {


    lateinit var btnText: String

    lateinit var list: List<String>

    var onClickListener: View.OnClickListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding =
            DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)

        //ActivityLoginBinding 是databinding自动生成 默认格式是类名+Binding

        var user = UserBean("Lisa Rong", "123456")

        binding.user = user

        btnText = "普通常量"

        binding.btnText = btnText

        list = listOf("123", "456", "String")
        binding.list = list

        onClickListener = View.OnClickListener {

            Toast.makeText(this, "点击", Toast.LENGTH_LONG).show()
        }

        binding.click = onClickListener

    }
}

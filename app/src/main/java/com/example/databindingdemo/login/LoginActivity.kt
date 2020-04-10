package com.example.databindingdemo.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.databindingdemo.R
import com.example.databindingdemo.databinding.ActivityLoginBinding
import com.example.databindingdemo.list.ListActivity
import com.example.databindingdemo.login.bean.UserBean
import com.example.databindingdemo.viewpager.ViewPagerActivity

class LoginActivity : AppCompatActivity() {


    lateinit var btnText: String

    lateinit var list: List<String>

    var onClickListener: View.OnClickListener? = null
    var onClickListener2: View.OnClickListener? = null
    var onClickListener3: View.OnClickListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding =
            DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)

        //ActivityLoginBinding 是databinding自动生成 默认格式是类名+Binding

        var user = UserBean("Lisa Rong", "123456")

        binding.user = user

        btnText = "普通常量"

        binding.btnText = btnText

        list = mutableListOf("123", "456", "String")
        binding.list = list

        onClickListener = View.OnClickListener {

            Toast.makeText(this, "点击", Toast.LENGTH_SHORT).show()

            startActivity(Intent(this, ListActivity::class.java))
        }

        binding.click = onClickListener

        onClickListener2 = View.OnClickListener {
            startActivity(Intent(this, ViewPagerActivity::class.java))
        }

        binding.click2 = onClickListener2

        onClickListener3 = View.OnClickListener {

            (list as MutableList<String>)[0] = (1 + list[0].toInt()).toString();
            binding.list = list

        }
        binding.click3 = onClickListener3


    }
}

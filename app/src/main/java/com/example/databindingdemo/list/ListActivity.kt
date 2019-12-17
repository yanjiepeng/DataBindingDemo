package com.example.databindingdemo.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.databindingdemo.R
import com.example.databindingdemo.databinding.ActivityListBinding
import com.example.databindingdemo.list.adapter.UserListAdapter
import com.example.databindingdemo.list.entity.UserBean
import com.example.databindingdemo.list.entity.UserBeanWithHeader

class ListActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding =
            DataBindingUtil.setContentView<ActivityListBinding>(this, R.layout.activity_list)

        val layoutManager = LinearLayoutManager(this)
        binding!!.rvList.layoutManager = layoutManager


        var adapter = UserListAdapter()

        adapter.data = getData()

        binding.rvList.adapter = adapter


        //通过双向绑定更新数据
        Handler(mainLooper).postDelayed({

            var user1 = adapter.data[1] as UserBeanWithHeader
            user1.headerUri.set("https://tx-free-imgs.acfun.cn/content/2019_11_15/1.5737976079824154E9.png")

            var user4 = adapter.data[3] as UserBean
            user4.userName.set("张张张张张张张张")

        }, 2000)


    }

    private fun getData(): MutableList<Any> {

        val user1: UserBeanWithHeader = UserBeanWithHeader()
        user1.userName.set("Kris Lee")
        user1.userAge.set("24")
        user1.headerUri.set("http://b-ssl.duitang.com/uploads/item/201511/13/20151113110434_kyReJ.jpeg")

        val user2: UserBeanWithHeader = UserBeanWithHeader()
        user2.userName.set("Zhang Sanfeng")
        user2.userAge.set("89")
        user2.headerUri.set("https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/whfpf%3D360%2C280%2C50/sign=d947d460c8cec3fd8b6bf435b0b5e709/9a504fc2d56285358588fb8d9bef76c6a7ef6335.jpg")

        val user3: UserBean = UserBean()
        user3.userAge = ObservableField<String>("14")
        user3.userName = ObservableField<String>("WuKL")


        val user4: UserBean = UserBean()
        user4.userAge = ObservableField<String>("12")
        user4.userName = ObservableField<String>("Zhang")


        val list = mutableListOf(user1, user2, user3, user4)



        return list


    }
}

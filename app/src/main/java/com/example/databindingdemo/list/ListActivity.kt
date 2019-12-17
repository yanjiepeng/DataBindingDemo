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
        Handler(mainLooper).postDelayed(Runnable {

            var user4 = adapter.data[3] as UserBean
            user4.userName.set("张张张张张张张张")

        },2000)


    }

    private fun getData(): MutableList<Any> {

        val user1: UserBeanWithHeader = UserBeanWithHeader(
            "Kris",
            "12",
            "http://b-ssl.duitang.com/uploads/item/201511/13/20151113110434_kyReJ.jpeg"
        )
        val user2: UserBeanWithHeader = UserBeanWithHeader(
            "Mango",
            "12",
            "http://tupian.qqjay.com/tou2/2019/0912/a1caaab7825a92c649ea3b2dddd99c9a.jpg"
        )
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

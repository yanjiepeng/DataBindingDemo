package com.example.databindingdemo.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
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
        val user4: UserBean = UserBean("Bruce", "14")
        val user3: UserBean = UserBean("Ali", "16")

        val list = mutableListOf(user1, user2, user3, user4)

        return list


    }
}

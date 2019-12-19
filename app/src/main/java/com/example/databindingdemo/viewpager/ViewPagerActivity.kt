package com.example.databindingdemo.viewpager

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.example.databindingdemo.BR
import com.example.databindingdemo.R
import com.example.databindingdemo.databinding.ActivityViewPagerBinding
import com.example.databindingdemo.viewpager.viewmodel.ViewPagerItemModel

class ViewPagerActivity : AppCompatActivity() {

    private lateinit var viewpager: ViewPager

    private val guide = arrayOf(
        "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576663390033&di=730d0a924db46019357729ad3962ec63&imgtype=jpg&src=http%3A%2F%2Fimg3.imgtn.bdimg.com%2Fit%2Fu%3D3992817968%2C1397776076%26fm%3D214%26gp%3D0.jpg",
        "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576663366853&di=8cf4396b2368802337fe5a6536bbb009&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0175cd58b77c62a801219c77391932.png%401280w_1l_2o_100sh.png",
        "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576663366853&di=62406d7412779ddfabf9690ba2647edc&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2Fbc608c9430155517e6fd15f3cc950f625cdb774b16a09-dZ7fZC_fw658",
        "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576663551403&di=52c6783c3745a97a7aa689e29951c6d0&imgtype=jpg&src=http%3A%2F%2Fimg1.imgtn.bdimg.com%2Fit%2Fu%3D2597631641%2C1350168820%26fm%3D214%26gp%3D0.jpg"
    )

    lateinit var lists: MutableList<ViewPagerItemModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityViewPagerBinding>(this, R.layout.activity_view_pager)

        viewpager = binding.viewpager
        lists = ArrayList()

        initData()

        val adapter = CommonViewPager<ViewPagerItemModel>(
            this,
            lists,
            BR.itemModel,
            R.layout.view_pager_item,
            layoutInflater
        )

        viewpager.adapter = adapter
    }

    private fun initData() {
        for (i in guide) {
            val v = ViewPagerItemModel()
            v.imageUrl = i
            lists.add(v)
        }
    }
}
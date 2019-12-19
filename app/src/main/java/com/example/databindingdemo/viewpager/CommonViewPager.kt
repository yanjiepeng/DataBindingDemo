package com.example.databindingdemo.viewpager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.viewpager.widget.PagerAdapter

class CommonViewPager<T> : PagerAdapter {

    var context: Context? = null
    var list: List<T>? = null
    var variableId: Int? = null
    var layoutId: Int? = null
    var inflater: LayoutInflater? = null

    constructor(
        context: Context?,
        list: List<T>?,
        variableId: Int?,
        layoutId: Int?,
        inflater: LayoutInflater?
    ) : super() {
        this.context = context
        this.list = list
        this.variableId = variableId
        this.layoutId = layoutId
        this.inflater = inflater
    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        val binding: ViewDataBinding = `object` as ViewDataBinding
        return view == binding.root
    }

    override fun getCount(): Int {
        return list!!.size
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        //返回databingding绑定的view

        var binding: ViewDataBinding =
            DataBindingUtil.inflate(inflater!!, layoutId!!, container, true)
        binding.setVariable(variableId!!, list!![position])

        //这里我们返回binding对象 这个binding对象是isViewFromObject 和destoryItem方法中的引用

        return binding

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        //移除binding 对应的view
        var binding: ViewDataBinding = `object` as ViewDataBinding
        container.removeView(binding.root)
    }

}
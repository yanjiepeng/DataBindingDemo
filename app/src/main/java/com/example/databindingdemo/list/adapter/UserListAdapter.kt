package com.example.databindingdemo.list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.example.databindingdemo.R
import com.example.databindingdemo.databinding.ItemUserImgBinding
import com.example.databindingdemo.databinding.ItemUserTextBinding
import com.example.databindingdemo.list.entity.UserBean
import com.example.databindingdemo.list.entity.UserBeanWithHeader
import com.tzsafe.base.BaseAdapter
import com.tzsafe.base.BaseViewHolder


class UserListAdapter : BaseAdapter<Any>() {
    override fun getDiffCllBack(
        oldData: MutableList<Any>,
        newData: MutableList<Any>
    ): DiffUtil.Callback {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {

        if (holder.dataBinding is ItemUserTextBinding) {
            (holder.dataBinding as ItemUserTextBinding).user = data[position] as UserBean
        }

        if (holder.dataBinding is ItemUserImgBinding) {
            (holder.dataBinding as ItemUserImgBinding).user = data[position] as UserBeanWithHeader
            Glide.with(holder.itemView.context).load((data[position] as UserBeanWithHeader).headerUri)
                .into((holder.dataBinding as ItemUserImgBinding).imageView)
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (data[position] is UserBean) return R.layout.item_user_text
        if (data[position] is UserBeanWithHeader) return R.layout.item_user_img
        return R.layout.item_user_text
    }

}

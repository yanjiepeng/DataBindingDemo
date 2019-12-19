package com.example.databindingdemo.list.entity

import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import com.bumptech.glide.Glide

class UserBeanWithHeader {

    var userName = ObservableField<String>()
    var userAge = ObservableField<String>()
    var headerUri = ObservableField<String>()


    companion object {

        @BindingAdapter("bind:img")
        fun setHeaderUri(view: ImageView, url: String) {
            Glide.with(view.context).load(url).into(view)
        }
    }

    public fun click(view: View) {

        Toast.makeText(view.context, userName.get(), Toast.LENGTH_LONG).show()

    }


}



package com.example.databindingdemo.viewpager.viewmodel

import android.widget.ImageView
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.library.baseAdapters.BR
import com.bumptech.glide.Glide


class ViewPagerItemModel : BaseObservable() {


    @get:Bindable
    var imageUrl: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.imageUrl)
        }


    companion object {
        @BindingAdapter("app:img")
        @JvmStatic
        fun setImage(view: ImageView, img: String) {
            Glide.with(view.context).load(img).into(view)
        }
    }


}

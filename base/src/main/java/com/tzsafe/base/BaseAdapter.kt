package com.tzsafe.base

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView


abstract class BaseAdapter<T>( var data: MutableList<T> = mutableListOf()) :
    RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                viewType,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    abstract fun getDiffCllBack(oldData: MutableList<T>, newData: MutableList<T>): DiffUtil.Callback

    fun refreshData(newData: MutableList<T>) {
        this.data = newData
        this.notifyDataSetChanged()
    }

    fun addItem(positon: Int, data: T) {
        this.data.add(positon, data)
        notifyItemInserted(positon)
    }

    fun removeItem(positon: Int) {
        this.data.removeAt(positon)
        notifyItemRemoved(positon)
    }

    fun refreshDatabyDiffUtils(newData: MutableList<T>) {

        var result: DiffUtil.DiffResult =
            DiffUtil.calculateDiff(getDiffCllBack(this.data, newData), true)
        this.data = newData
        result.dispatchUpdatesTo(this)
    }

}

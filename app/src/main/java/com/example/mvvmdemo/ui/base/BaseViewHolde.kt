package com.example.mvvmdemo.ui.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun onBind(Position: Int)


}
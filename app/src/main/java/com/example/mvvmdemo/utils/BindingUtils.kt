package com.example.mvvmdemo.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmdemo.data.model.userResponse.Data
import com.example.mvvmdemo.data.model.userResponse.UserResponse
import com.example.mvvmdemo.ui.users.usersListAdapter.UsersListAdapter

object BindingUtils {

    @JvmStatic
    @BindingAdapter("addPlacesItems")
    fun addPlaceItems(recyclerView: RecyclerView, list: List<Data>?) {
        if (recyclerView.adapter != null) {
            var mUsersListAdapter: UsersListAdapter? = checkNotNull(recyclerView.adapter) as UsersListAdapter?
            mUsersListAdapter?.let {
                it.clearItems()
                list?.let { it1 -> it.addItems(it1) }
            }
        }
    }

    @JvmStatic
    @BindingAdapter("lodeImage")
    fun imageBinding(imageView: ImageView, url: String) {
        Glide.with(imageView.context).load(url).into(imageView)
    }

}
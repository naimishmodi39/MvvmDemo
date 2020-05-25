package com.example.mvvmdemo.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.benchmate.sports.data.responsebean.PlacesResponse.ResultsItem
import com.bumptech.glide.Glide
import com.example.mvvmdemo.ui.googlePlaces.placesAdapter.PlacesAdapter

object BindingUtils {

    @JvmStatic
    @BindingAdapter("addPlacesItems")
    fun addPlaceItems(recyclerView: RecyclerView, list: List<ResultsItem>?) {
        if (recyclerView.adapter != null) {
            var mPlacesAdapter: PlacesAdapter? = checkNotNull(recyclerView.adapter) as PlacesAdapter?
            mPlacesAdapter?.let {
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
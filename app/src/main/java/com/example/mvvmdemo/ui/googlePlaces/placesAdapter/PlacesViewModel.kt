package com.example.mvvmdemo.ui.googlePlaces.placesAdapter

import androidx.databinding.ObservableField
import com.benchmate.sports.data.responsebean.PlacesResponse.ResultsItem

class PlacesViewModel constructor(
    val mListener: PlacesItemViewModelListener,
    mResult: ResultsItem
) {

    var image: ObservableField<String>
    var name: ObservableField<String>


    fun onItemClickListener() {
        mListener.OnItemClickListener()
    }

    interface PlacesItemViewModelListener {
        fun OnItemClickListener()
    }

    init {
        image = ObservableField(mResult.icon!!)
        name = ObservableField(mResult.name!!)
    }

}
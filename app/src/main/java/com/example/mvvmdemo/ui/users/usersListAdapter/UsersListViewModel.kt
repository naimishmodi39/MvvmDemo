package com.example.mvvmdemo.ui.users.usersListAdapter

import androidx.databinding.ObservableField
import com.example.mvvmdemo.data.model.userResponse.Data
class UsersListViewModel constructor(
    val mListener: PlacesItemViewModelListener,
    mResult: Data
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
        image = ObservableField(mResult.avatar!!)
        name = ObservableField(mResult.email!!)
    }

}
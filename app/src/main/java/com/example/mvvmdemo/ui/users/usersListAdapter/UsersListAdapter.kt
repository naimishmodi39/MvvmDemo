package com.example.mvvmdemo.ui.users.usersListAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.mvvmdemo.data.model.userResponse.Data
import com.example.mvvmdemo.databinding.ItemEmptyUserBinding
import com.example.mvvmdemo.databinding.ItemUserBinding
import com.example.mvvmdemo.ui.base.BaseViewHolder

class UsersListAdapter : RecyclerView.Adapter<BaseViewHolder>() {

    val VIEW_TYPE_NORMAL: Int = 1
    val VIEW_TYPE_Empty: Int = 0

    var listOfPlaces: ArrayList<Data> = arrayListOf()
    lateinit var mListener: BlogAdapterListener

    override fun getItemViewType(position: Int): Int {
        return if (listOfPlaces.size > 0) VIEW_TYPE_NORMAL else VIEW_TYPE_Empty
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        when (viewType) {
            VIEW_TYPE_Empty -> {

                val mbinding = ItemEmptyUserBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return EmptyViewHolder(mbinding)
            }
            else -> {
                val mbinding =
                    ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return PlacesViewHolder(mbinding)
            }
        }
    }

    fun addItems(list: List<Data>) {
        listOfPlaces = list as ArrayList<Data>
        notifyDataSetChanged()
    }

    fun clearItems() {
        listOfPlaces.clear()
    }

    fun setListner(mListener: BlogAdapterListener) {
        this.mListener = mListener
    }

    interface BlogAdapterListener {
        fun onRetryClick()
    }

    override fun getItemCount(): Int {
        return if (listOfPlaces.size > 0) listOfPlaces.size else 1

    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }


    inner class EmptyViewHolder constructor(binding: ItemEmptyUserBinding) :
        BaseViewHolder(binding.root),
        UsersListEmptyViewModel.PlacesEmptyViewHolderEmptyClickListener {

        var mbinding: ItemEmptyUserBinding
        lateinit var mUsersListEmptyViewModel: UsersListEmptyViewModel

        override fun onBind(Position: Int) {
            mUsersListEmptyViewModel = UsersListEmptyViewModel(this)
            mbinding.viewModel = mUsersListEmptyViewModel
        }

        override fun onRetryClick() {
            mListener.onRetryClick()
        }

        init {
            this.mbinding = binding
        }
    }


    inner class PlacesViewHolder(binding: ItemUserBinding) : BaseViewHolder(binding.root),
        UsersListViewModel.PlacesItemViewModelListener {

        var mbinding: ItemUserBinding
        lateinit var mPlacesViewModel: UsersListViewModel

        override fun onBind(Position: Int) {
            val result: Data = listOfPlaces.get(Position)
            mbinding.viewModel = UsersListViewModel(this, result)
            mbinding.executePendingBindings()
        }

        override fun OnItemClickListener() {
//            Toast.makeText()
        }

        init {
            this.mbinding = binding
        }
    }

}
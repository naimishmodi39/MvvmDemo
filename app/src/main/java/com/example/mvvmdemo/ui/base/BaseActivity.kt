package com.example.mvvmdemo.ui.base

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.mvvmdemo.utils.Utils
import dagger.android.AndroidInjection

//@RuntimePermissions
abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel<*>?> : AppCompatActivity(),BaseFragment.Callback {

    lateinit var mViewDataBinding: T
    var mViewModel: V? = null
    lateinit var mProgressDialog: ProgressDialog

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModel(): V

    open fun getViewDataBinding(): T {
        return mViewDataBinding
    }


    abstract fun getBindingVariable(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
        performViewBainding()
    }

    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String?) {
    }

    open fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }


    open fun hideLoading() {
        if (::mProgressDialog.isInitialized && mProgressDialog.isShowing()) {
            mProgressDialog.cancel()
        }
    }

    open fun showLoading() {
        hideLoading()
        mProgressDialog = Utils.showLodingDialog(this)
    }

    open fun openActivityOnTokenExpire() {
//        startActivity(LoginActivity.newIntent(this))
        finish()
    }


    fun performDependencyInjection() {
        AndroidInjection.inject(this)
    }

    fun performViewBainding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        mViewModel = if (mViewModel == null) getViewModel() else mViewModel
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel)
        mViewDataBinding.executePendingBindings()
    }
}
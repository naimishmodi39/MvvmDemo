package com.example.mvvmdemo.data.model

import com.google.gson.annotations.SerializedName


open class BaseBean {

    @SerializedName("code")
    var code = 0
    @SerializedName("message")
    var message: String? = null

    val isSuccess: Boolean
        get() = code == 0


    /* fun equals(o: Any): Boolean {
        if (this === o) return true
        if (o !is BaseBean) return false
        val that: BaseBean = o as BaseBean
        if (!code.equals(that.code)) return false
        return if (message = that.message) false else data.equals(that.data)
    }

    override fun hashCode(): Int {
        var result: Int = code.hashCode()
        result = 31 * result + message.hashCode()
        return result
    }*/
}
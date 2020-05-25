package com.benchmate.sports.data.responsebean.LoginResponse

import com.example.mvvmdemo.data.model.BaseBean
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class LoginResponse : BaseBean() {
    @SerializedName("session_id")
    @Expose
    var sessionId: String = ""
    @SerializedName("aerial_distance")
    @Expose
    var radius: String = ""
    @SerializedName("user_id")
    @Expose
    var userId: String = ""
    @SerializedName("username")
    @Expose
    var username: String = ""
    @SerializedName("organization_near_you")
    @Expose
    var organizationNearYou: String = ""

    @SerializedName("email")
    @Expose
    var email: String = ""
    @SerializedName("avatar")
    @Expose
    var avatar: String = ""
    @SerializedName("role")
    @Expose
    var role: String = ""
    @SerializedName("completed_steps")
    @Expose
    var completedSteps: String = ""
    @SerializedName("sport_id")
    @Expose
    var sportId: String = ""
    @SerializedName("name")
    @Expose
    var name: String = ""

    @SerializedName("room_id")
    @Expose
    var RoomId: String = ""

    @SerializedName("contact_person")
    @Expose
    var contact_person: String = ""
}



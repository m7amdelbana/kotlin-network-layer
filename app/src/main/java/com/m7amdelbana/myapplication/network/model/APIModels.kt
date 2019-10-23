package com.m7amdelbana.myapplication.network.model

import com.google.gson.annotations.SerializedName

data class SignForm(
    @SerializedName("firstName") var firstName: String? = null,
    @SerializedName("lastName") var lastName: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("password") var password: String? = null
)

data class Token(
    @SerializedName("x-auth-token") var accessToken: String? = null
)

data class Place(
    @SerializedName("image") var image: String? = null,
    @SerializedName("coverImage") var coverImage: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("address") var address: String? = null,
    @SerializedName("lat") var lat: Double? = 0.0,
    @SerializedName("lng") var lng: Double? = 0.0,
    @SerializedName("rating") var rating: Double? = 0.0,
    @SerializedName("totalRating") var totalRating: Long? = 0,
    @SerializedName("hourPrice") var hourPrice: Int? = 0,
    @SerializedName("dayPrice") var dayPrice: Int? = 0,
    @SerializedName("capacity") var capacity: Int? = 0
)
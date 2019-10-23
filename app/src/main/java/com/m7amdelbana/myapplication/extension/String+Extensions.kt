package com.m7amdelbana.myapplication.extension

fun String.isValidEmail(): Boolean {
    val EMAIL_REGEX = "^[A-Za-z](.*)([@])(.+)(\\.)(.+)"
    return EMAIL_REGEX.toRegex().matches(this)
}

fun String.isValidPassword(): Boolean {
    return this.length >= 6
}

fun String.isValidPhone(): Boolean {
    return this.length in 11..13
}
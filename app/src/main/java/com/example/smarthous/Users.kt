package com.example.smarthous

import kotlinx.serialization.Serializable

@Serializable
data class Users(val id: String = "", val Логин: String = "", val Адрес: String = "")
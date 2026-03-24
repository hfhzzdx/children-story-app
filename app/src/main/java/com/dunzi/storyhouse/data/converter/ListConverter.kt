package com.dunzi.storyhouse.data.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object ListConverter {
    private val gson = Gson()

    @TypeConverter
    @JvmStatic
    fun fromStringList(value: String?): List<String> {
        if (value.isNullOrBlank()) return emptyList()
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    @JvmStatic
    fun toString(value: List<String>?): String {
        return gson.toJson(value ?: emptyList())
    }
}

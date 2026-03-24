package com.dunzi.storyhouse.data.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object MapConverter {
    private val gson = Gson()

    @TypeConverter
    @JvmStatic
    fun fromStringMap(value: String?): Map<String, String> {
        if (value.isNullOrBlank()) return emptyMap()
        val type = object : TypeToken<Map<String, String>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    @JvmStatic
    fun toString(value: Map<String, String>?): String {
        return gson.toJson(value ?: emptyMap())
    }
}

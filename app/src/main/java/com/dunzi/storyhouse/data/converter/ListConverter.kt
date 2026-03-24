package com.dunzi.storyhouse.data.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

/**
 * List<String> 类型转换器
 */
class ListConverter {
    private val gson = Gson()
    private val type: Type = object : TypeToken<List<String>>() {}.type

    @TypeConverter
    fun fromString(value: String?): List<String> {
        return if (value.isNullOrEmpty()) {
            emptyList()
        } else {
            try {
                gson.fromJson<List<String>>(value, type)
            } catch (e: Exception) {
                emptyList()
            }
        }
    }

    @TypeConverter
    fun toString(list: List<String>?): String {
        return gson.toJson(list ?: emptyList())
    }
}
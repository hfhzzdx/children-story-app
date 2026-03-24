package com.dunzi.storyhouse.data.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

/**
 * Map<String, String> 类型转换器
 */
class MapConverter {
    private val gson = Gson()
    private val type: Type = object : TypeToken<Map<String, String>>() {}.type

    @TypeConverter
    fun fromString(value: String?): Map<String, String> {
        return if (value.isNullOrEmpty()) {
            emptyMap()
        } else {
            try {
                @Suppress("UNCHECKED_CAST")
                gson.fromJson<Map<String, String>>(value, type) as Map<String, String>
            } catch (e: Exception) {
                emptyMap()
            }
        }
    }

    @TypeConverter
    fun toString(map: Map<String, String>?): String {
        return gson.toJson(map ?: emptyMap())
    }
}
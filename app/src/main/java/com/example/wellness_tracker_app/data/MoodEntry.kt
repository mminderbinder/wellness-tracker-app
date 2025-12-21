package com.example.wellness_tracker_app.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(
    tableName = "mood_entry"
)
data class MoodEntry(
    @PrimaryKey
    val date: String,
    @ColumnInfo(name = "day_mood")
    val dayMood: Int? = null,
    @ColumnInfo(name = "night_mood")
    val nightMood: Int? = null,
    @ColumnInfo(name = "sleep_duration")
    val sleepDuration: Double? = null,
    @ColumnInfo(name = "menstruation")
    val isMenstruating: Boolean? = null,
    @ColumnInfo(name = "notes")
    val notes: String? = null,
    @ColumnInfo(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @ColumnInfo(name = "updated_at")
    val updatedAt: LocalDateTime = LocalDateTime.now()
)
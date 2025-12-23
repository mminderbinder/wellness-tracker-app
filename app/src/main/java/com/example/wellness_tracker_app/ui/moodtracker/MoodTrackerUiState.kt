package com.example.wellness_tracker_app.ui.moodtracker

import java.time.LocalDate

data class MoodTrackerUiState(
    val selectedDate: LocalDate = LocalDate.now(),
    val startDate: LocalDate = LocalDate.now().minusDays(500),
    val endDate: LocalDate = LocalDate.now(),
    val moodEntries: Map<LocalDate, MoodData> = emptyMap(),
    val isLoading: Boolean = false,
    val error: String? = null
)

data class MoodData(
    val dayMood: Int? = null,
    val nightMood: Int? = null,
    val sleepDuration: Double? = null,
    val isMenstruating: Boolean? = null,
    val notes: String? = null
) {
    val hasDayMood: Boolean get() = dayMood != null
    val hasNightMood: Boolean get() = nightMood != null
}
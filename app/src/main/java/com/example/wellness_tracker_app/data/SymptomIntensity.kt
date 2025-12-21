package com.example.wellness_tracker_app.data

enum class SymptomIntensity(
    val value: Int,
    val displayName: String
) {
    MILD(1, "Mild"),
    MODERATE(2, "Moderate"),
    HIGH(3, "High"),
    EXTREME(4, "Extreme");
}
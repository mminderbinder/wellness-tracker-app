package com.example.wellness_tracker_app.data

enum class SleepQuality(
    val value: Int,
    val displayName: String
) {
    GREAT(4, "Great"),
    GOOD(3, "Good"),
    FAIR(2, "Fair"),
    POOR(1, "Poor"),
    TERRIBLE(0, "Terrible");
}
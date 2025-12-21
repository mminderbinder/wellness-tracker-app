package com.example.wellness_tracker_app.data

enum class MoodScale(
    val value: Int,
    val displayName: String
) {
    EXTREMELY_ELEVATED(4, "Extremely elevated"),
    VERY_ELEVATED(3, "Very elevated"),
    SOMEWHAT_ELEVATED(2, "Somewhat elevated"),
    MILDLY_ELEVATED(1, "Mildly elevated"),

    NEUTRAL(0, "Neutral"),

    MILDLY_DEPRESSED(-1, "Mildly depressed"),
    SOMEWHAT_DEPRESSED(-2, "Somewhat depressed"),
    VERY_DEPRESSED(-3, "Very depressed"),
    EXTREMELY_DEPRESSED(-4, "Extremely depressed");

    companion object {
        fun fromValue(value: Int) : MoodScale? =
            entries.find { it.value == value }
    }
}
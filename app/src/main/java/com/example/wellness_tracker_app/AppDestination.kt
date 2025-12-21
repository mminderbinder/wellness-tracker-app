package com.example.wellness_tracker_app

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.Mood
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.wellness_tracker_app.AppDestination.MoodTracker
import com.example.wellness_tracker_app.AppDestination.SymptomTracker


sealed class AppDestination(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object MoodTracker : AppDestination(
        route = "mood_tracker",
        title = "Mood Tracker",
        icon = Icons.Filled.Mood
    )

    object SymptomTracker : AppDestination(
        route = "symptom_tracker",
        title = "Symptom Tracker",
        icon = Icons.Filled.LocalHospital
    )
}

val bottomNavDestinations = listOf(
    MoodTracker,
    SymptomTracker
)
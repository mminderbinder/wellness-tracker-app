package com.example.wellness_tracker_app.ui.moodtracker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wellness_tracker_app.ui.moodtracker.components.CalendarDay
import com.example.wellness_tracker_app.ui.moodtracker.components.DaysOfWeekTitle
import com.example.wellness_tracker_app.ui.theme.WellnessAppTheme
import com.example.wellness_tracker_app.ui.utils.getWeekPageTitle
import com.kizitonwose.calendar.compose.WeekCalendar
import com.kizitonwose.calendar.compose.weekcalendar.rememberWeekCalendarState
import com.kizitonwose.calendar.core.firstDayOfWeekFromLocale
import kotlinx.coroutines.flow.filter
import java.time.LocalDate

@Composable
fun MoodTrackerScreen() {
    MoodTrackerContent(
        uiState = MoodTrackerUiState(),
        onDayMoodClick = {},
        onNightMoodClick = {},
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MoodTrackerContent(
    uiState: MoodTrackerUiState,
    onDayMoodClick: (LocalDate) -> Unit,
    onNightMoodClick: (LocalDate) -> Unit,
) {
    val firstDayOfWeek = remember { firstDayOfWeekFromLocale() }
    val currentDate = remember { LocalDate.now() }

    Column(
        modifier = Modifier.fillMaxWidth()

    ) {
        val state = rememberWeekCalendarState(
            startDate = uiState.startDate,
            endDate = uiState.endDate,
            firstVisibleWeekDate = currentDate,
            firstDayOfWeek = firstDayOfWeek
        )

        val visibleWeek = remember(state.firstVisibleWeek) {
            state.firstVisibleWeek
        }

        LaunchedEffect(state) {
            snapshotFlow { state.isScrollInProgress }
                .filter { !it }
                .collect {

                }
        }

        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(),
            title = { Text(text = getWeekPageTitle(visibleWeek)) }
        )

        val daysOfWeek = remember(firstDayOfWeek) {
            List(7) { index ->
                firstDayOfWeek.plus(index.toLong())
            }
        }

        DaysOfWeekTitle(
            daysOfWeek = daysOfWeek,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        WeekCalendar(
            state = state,
            dayContent = { day ->
                CalendarDay(
                    date = day.date,
                    hasDayMood = false,
                    hasNightMood = false,
                    isSelected = false,
                    onDayMoodClick = onDayMoodClick,
                    onNightMoodClick = onNightMoodClick,
                )
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun MoodTrackerScreenPreview() {
    val today = LocalDate.now()
    WellnessAppTheme {
        MoodTrackerContent(
            uiState = MoodTrackerUiState(

            ),
            onDayMoodClick = {},
            onNightMoodClick = {},
        )
    }
}
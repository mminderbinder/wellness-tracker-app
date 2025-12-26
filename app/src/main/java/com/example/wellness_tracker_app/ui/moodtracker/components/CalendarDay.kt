package com.example.wellness_tracker_app.ui.moodtracker.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Nightlight
import androidx.compose.material.icons.outlined.WbSunny
import androidx.compose.material.icons.outlined.WbTwilight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wellness_tracker_app.ui.theme.WellnessAppTheme
import java.time.LocalDate

@Composable
fun CalendarDay(
    date: LocalDate,
    hasDayMood: Boolean,
    hasNightMood: Boolean,
    isSelected: Boolean,
    onDayMoodClick: (LocalDate) -> Unit,
    onNightMoodClick: (LocalDate) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(32.dp)
        ) {
            Text(
                text = date.dayOfMonth.toString(),
                style = MaterialTheme.typography.titleSmall,
                textAlign = TextAlign.Center,
                color = if (isSelected) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.onSurface
                }
            )
            if (isSelected) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f))
                )
            }
        }
        OutlinedIconButton(
            onClick = { onDayMoodClick(date) },
            modifier = Modifier.size(40.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.WbSunny,
                contentDescription = "Day mood",
                tint = if (hasDayMood) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.onSurfaceVariant
                }
            )
        }
        OutlinedIconButton(
            onClick = { onNightMoodClick(date) },
            modifier = Modifier.size(40.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.Nightlight,
                contentDescription = "Night mood",
                tint = if (hasNightMood) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.onSurfaceVariant
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CalendarDayPreview() {
    WellnessAppTheme {
        CalendarDay(
            date = LocalDate.now(),
            hasDayMood = true,
            hasNightMood = false,
            isSelected = true,
            onDayMoodClick = {},
            onNightMoodClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CalendarDayBothMoodsPreview() {
    WellnessAppTheme {
        CalendarDay(
            date = LocalDate.now(),
            hasDayMood = true,
            hasNightMood = true,
            isSelected = false,
            onDayMoodClick = {},
            onNightMoodClick = {},
        )
    }
}
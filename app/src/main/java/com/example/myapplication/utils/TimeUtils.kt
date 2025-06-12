package com.example.myapplication.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun timeAgo(timestamp: Long): String {
    val diff = System.currentTimeMillis() - timestamp
    val minutes = diff / (1000 * 60)
    return when {
        minutes < 1 -> "Just now"
        minutes < 60 -> "$minutes minutes ago"
        else -> "${minutes / 60} hours ago"
    }
}
fun formatLastWatered(timestamp: Long): String {
    val sdf = SimpleDateFormat("MMM dd, yyyy 'at' HH:mm", Locale.getDefault())
    return sdf.format(Date(timestamp))
}
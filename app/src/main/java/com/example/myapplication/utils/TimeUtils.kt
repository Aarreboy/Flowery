package com.example.myapplication.utils

fun timeAgo(timestamp: Long): String {
    val diff = System.currentTimeMillis() - timestamp
    val minutes = diff / (1000 * 60)
    return when {
        minutes < 1 -> "Just now"
        minutes < 60 -> "$minutes minutes ago"
        else -> "${minutes / 60} hours ago"
    }
}
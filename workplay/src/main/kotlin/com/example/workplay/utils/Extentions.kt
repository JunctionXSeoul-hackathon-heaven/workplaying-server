package com.example.workplay.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun String.strToDate(): LocalDateTime {
    return LocalDateTime.parse(this, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
}
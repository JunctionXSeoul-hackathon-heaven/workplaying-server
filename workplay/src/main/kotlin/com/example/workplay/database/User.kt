package com.example.workplay.database

import java.time.LocalDateTime

data class User(
    var id: Int? = null,
    var name: String? = null,
    var company: String? = null,
    var competitions: MutableList<Int>? = null,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null
)
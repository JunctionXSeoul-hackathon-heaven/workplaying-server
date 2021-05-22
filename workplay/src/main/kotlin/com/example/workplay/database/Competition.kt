package com.example.workplay.database

import java.time.LocalDateTime

data class Competition(
    var id: Int? =null,
    var title: String? = null,
    var reward: Int? = null,
    var startDate: LocalDateTime? = null,
    var endDate: LocalDateTime? = null,
    var gameCategory: String? = null,
    var description: String? = null,
    var host: Company? = null,
    var users: MutableList<User>? = null,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null
)
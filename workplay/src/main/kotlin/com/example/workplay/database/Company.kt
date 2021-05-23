package com.example.workplay.database

import java.time.LocalDateTime

data class Company(
    var id: Int? = null,
    var name: String? = null,
    var logo: String? = null,
    var competitions: MutableList<Int>? = null,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null

    )
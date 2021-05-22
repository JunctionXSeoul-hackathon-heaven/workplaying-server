package com.example.workplay.model.http

import com.example.workplay.database.Competition
import com.example.workplay.database.User
import java.time.LocalDateTime
import javax.validation.constraints.AssertTrue
import javax.validation.constraints.NotBlank

data class UserDto(
    var id: Int? = null,

    @field:NotBlank
    var name: String? = null,

    @field:NotBlank
    var company: String? = null,

    var competitions: MutableList<Competition>? = null,

    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null
)

fun User.convertUser(userDto: UserDto): User {
    return User().apply {
        this.id = userDto.id
        this.name = userDto.name
        this.company = userDto.company
        this.competitions = userDto.competitions
        this.createdAt = userDto.createdAt
        this.updatedAt = userDto.updatedAt
    }
}

fun UserDto.convertUserDto(user: User): UserDto {
    return UserDto().apply {
        this.id = user.id
        this.name = user.name
        this.company = user.company
        this.competitions = user.competitions
        this.createdAt = user.createdAt
        this.updatedAt = user.updatedAt
    }
}
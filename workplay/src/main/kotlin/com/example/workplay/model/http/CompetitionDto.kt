package com.example.workplay.model.http

import com.example.workplay.database.Company
import com.example.workplay.database.Competition
import com.example.workplay.database.User
import com.example.workplay.utils.strToDate
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.AssertTrue
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive


@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class CompetitionDto(
    var id: Int? =null,

    @field:NotBlank
    var title: String? = null,

    @field:Positive
    var reward: Int? = null,

    @field:NotBlank
    var startDate: String? = null,

    @field:NotBlank
    var endDate: String? = null,

    @field:NotBlank
    @JsonProperty("game_category")
    var gameCategory: String? = null,

    var host: String? = null,
    var description: String? = null,
    var users: MutableList<Int>? = null,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null
) {
    @AssertTrue(message="yyyy-MM-dd HH:mm:ss 포맷이 맞지 않습니다.")
    fun validStartDate(): Boolean {
        return try {
            LocalDateTime.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            true
        }catch (e: Exception) {
            false
        }
    }

    @AssertTrue(message="yyyy-MM-dd HH:mm:ss 포맷이 맞지 않습니다.")
    fun validEndDate(): Boolean {
        return try {
            LocalDateTime.parse(endDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            true
        }catch (e: Exception) {
            false
        }
    }
}

fun Competition.convertCompetition(competitionDto: CompetitionDto): Competition {
    return Competition().apply {
        this.id = competitionDto.id
        this.title = competitionDto.title
        this.reward = competitionDto.reward
        this.startDate = competitionDto.startDate?.strToDate()
        this.endDate = competitionDto.endDate?.strToDate()
        this.gameCategory = competitionDto.gameCategory
        this.description = competitionDto.description
        this.host = competitionDto.host
        this.users = competitionDto.users
        this.createdAt = competitionDto.createdAt
        this.updatedAt = competitionDto.updatedAt
    }
}

fun CompetitionDto.convertCompetitionDto(competition: Competition): CompetitionDto {
    return CompetitionDto().apply {
        this.id = competition.id
        this.title = competition.title
        this.reward = competition.reward
        this.startDate = competition.startDate?.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        this.endDate = competition.endDate?.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        this.gameCategory = competition.gameCategory
        this.description = competition.description
        this.host = competition.host
        this.users = competition.users
        this.createdAt = competition.createdAt
        this.updatedAt = competition.updatedAt
    }
}
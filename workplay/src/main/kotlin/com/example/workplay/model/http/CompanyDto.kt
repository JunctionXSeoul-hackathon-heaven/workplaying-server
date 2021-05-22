package com.example.workplay.model.http

import com.example.workplay.database.Company
import com.example.workplay.database.Competition
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.time.LocalDateTime

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class CompanyDto(
    var id: Int? = null,
    var name: String? = null,
    var logo: String? = null,
    var competitions: MutableList<Competition>? = null,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null
)

fun Company.convertCompany(companyDto: CompanyDto): Company {
    return Company().apply {
        this.id = companyDto.id
        this.name = companyDto.name
        this.logo = companyDto.logo
        this.competitions = companyDto.competitions
        this.createdAt = companyDto.createdAt
        this.updatedAt = companyDto.updatedAt   
    }
}

fun CompanyDto.convertCompanyDto(company: Company): CompanyDto {
    return CompanyDto().apply {
        this.id = company.id
        this.name = company.name
        this.logo = company.logo
        this.competitions = company.competitions
        this.createdAt = company.createdAt
        this.updatedAt = company.updatedAt
    }
}
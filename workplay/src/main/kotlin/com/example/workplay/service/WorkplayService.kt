package com.example.workplay.service

import com.example.workplay.database.Company
import com.example.workplay.database.Competition
import com.example.workplay.database.User
import com.example.workplay.model.http.*
import com.example.workplay.repository.WorkplayRepository
import org.springframework.stereotype.Service

@Service
class WorkplayService (
    val workplayRepository: WorkplayRepository
) {
    // user create
    fun createUser(userDto: UserDto): UserDto {
        return userDto.let {
            workplayRepository.saveUser(
                User().convertUser(it)
            )
        }.let {
            UserDto().convertUserDto(it)
        }
    }
    
    // user read
    fun readUser(index: Int): UserDto? {
        return workplayRepository.findUserOne(index)?.let {
            UserDto().convertUserDto(it)
        }
    }
    
    // user readAll
    fun readAllUser(): MutableList<UserDto> {
        return workplayRepository.findUserAll()
            .map { 
                UserDto().convertUserDto(it)
            }.toMutableList()
    }
    
    // user update
    fun updateUser(userDto: UserDto): UserDto? {
        return userDto.let {
            workplayRepository.updateUser(
                User().convertUser(it)
            )
        }?.let {
            UserDto().convertUserDto(it)
        }
    }
    
    // user delete
    fun deleteUser(index: Int): Boolean {
        return workplayRepository.deleteUser(index)
    }
    
    // competition create
    fun createCompetition(competitionDto: CompetitionDto): CompetitionDto {
        return competitionDto.let {
            workplayRepository.saveCompetition(
                Competition().convertCompetition(it)
            )
        }.let {
            CompetitionDto().convertCompetitionDto(it)
        }
    }
    
    // competition read
    fun readCompetition(index: Int): CompetitionDto? {
        return workplayRepository.findCompetitionOne(index)?.let {
            CompetitionDto().convertCompetitionDto(it)
        }
    }
    
    // competition readAll
    fun readAllCompetition(): MutableList<CompetitionDto> {
        return workplayRepository.findCompetitionAll()
            .map {
                CompetitionDto().convertCompetitionDto(it)
            }.toMutableList()
    }
    
    // competition update
    fun updateCompetition(competitionDto: CompetitionDto): CompetitionDto? {
        return competitionDto.let {
            workplayRepository.updateCompetition(
                Competition().convertCompetition(it)
            )
        }?.let {
            CompetitionDto().convertCompetitionDto(it)
        }
    }
    
    // competition delete
    fun deleteCompetition(index: Int): Boolean {
        return workplayRepository.deleteCompetition(index)
    }

    // company create
    fun createCompany(companyDto: CompanyDto): CompanyDto {
        return companyDto.let {
            workplayRepository.saveCompany(
                Company().convertCompany(it)
            )
        }.let {
            CompanyDto().convertCompanyDto(it)
        }
    }
    
    // company read
    fun readCompany(index: Int): CompanyDto? {
        return workplayRepository.findCompanyOne(index)?.let {
            CompanyDto().convertCompanyDto(it)
        }
    }
    
    // company readAll
    fun readAllCompany(): MutableList<CompanyDto> {
        return workplayRepository.findCompanyAll()
            .map {
                CompanyDto().convertCompanyDto(it)
            }.toMutableList()
    }
    
    // company update
    fun updateCompany(companyDto: CompanyDto): CompanyDto? {
        return companyDto.let {
            workplayRepository.updateCompany(
                Company().convertCompany(it)
            )
        }?.let {
            CompanyDto().convertCompanyDto(it)
        }
    }

    // company delete
    fun deleteCompany(index: Int): Boolean {
        return workplayRepository.deleteCompany(index)
    }
}
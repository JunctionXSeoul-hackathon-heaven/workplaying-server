package com.example.workplay.repository

import com.example.workplay.database.Company
import com.example.workplay.database.Competition
import com.example.workplay.database.User
import com.example.workplay.database.WorkplayDatabase
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class WorkplayRepository(
    var workplayDatabase: WorkplayDatabase
): WorkplayRepositoryInterface {
    override fun saveUser(user: User): User {
        return user.apply {
            this.id = ++workplayDatabase.userIndex
            this.createdAt = LocalDateTime.now()
            this.updatedAt = LocalDateTime.now()
            this.competitions = mutableListOf()

            workplayDatabase.userList.add(this)
        }
    }

    override fun saveCompetition(competition: Competition): Competition {
        return competition.apply {
            val id = ++workplayDatabase.competitionIndex
            this.id = id
            this.users = mutableListOf()
            this.createdAt = LocalDateTime.now()
            this.updatedAt = LocalDateTime.now()

            workplayDatabase.companyList.forEach { company ->
                if(company.name == competition.host)
                    company.competitions?.add(id)
            }

            workplayDatabase.competitionList.add(this)
        }
    }

    override fun saveCompany(company: Company): Company {
        return company.apply {
            this.id = ++workplayDatabase.companyIndex
            this.competitions = mutableListOf()
            this.createdAt = LocalDateTime.now()
            this.updatedAt = LocalDateTime.now()

            workplayDatabase.companyList.add(this)
        }
    }
    

    override fun deleteUser(index: Int): Boolean {
        return findUserOne(index)?.let { user ->
            workplayDatabase.userList.remove(user)
            true
        }?: kotlin.run {
            false
        }
    }

    override fun deleteCompetition(index: Int): Boolean {
        return findCompetitionOne(index)?.let { competition ->
            workplayDatabase.competitionList.remove(competition)
            true
        }?: kotlin.run {
            false
        }
    }

    override fun deleteCompany(index: Int): Boolean {
        return findCompanyOne(index)?.let { company ->
            workplayDatabase.companyList.remove(company)
            true
        }?: kotlin.run {
            false
        }
    }

    override fun findUserOne(index: Int): User? {
        return workplayDatabase.userList.first { user->
            user.id == index
        }
    }

    override fun findUserAll(): MutableList<User> {
        return workplayDatabase.userList
    }

    override fun findCompetitionOne(index: Int): Competition? {
        return workplayDatabase.competitionList.first { competition->
            competition.id == index
        }
    }

    override fun findCompetitionAll(): MutableList<Competition> {
        return workplayDatabase.competitionList
    }

    override fun findCompanyOne(index: Int): Company? {
        return workplayDatabase.companyList.first { company->
            company.id == index
        }
    }

    override fun findCompanyAll(): MutableList<Company> {
        return workplayDatabase.companyList
    }

    fun join(userId: Int, competitionId: Int): Boolean {
        var user = findUserOne(userId)
        var competition = findCompetitionOne(competitionId)

        if (user != null && competition != null) {
            user.competitions?.add(userId)
            competition.users?.add(competitionId)
            return true
        }

        return false
    }

    fun cancel(userId: Int, competitionId: Int): Boolean {
        var user = findUserOne(userId)
        var competition = findCompetitionOne(competitionId)

        if (user != null && competition != null) {
            user.competitions?.remove(userId)
            competition.users?.remove(competitionId)
            return true
        }

        return false
    }

    override fun updateUser(user: User): User? {
        println(user)
        return user.id?.let {
            findUserOne(it)?.apply {
                this.name = user.name
                this.company = user.company
                this.updatedAt = LocalDateTime.now()
            }
        }
    }

    override fun updateCompetition(competition: Competition): Competition? {
        return competition.id?.let {
            findCompetitionOne(it)?.apply {
                this.title = competition.title
                this.reward = competition.reward
                this.startDate = competition.startDate
                this.endDate = competition.endDate
                this.gameCategory = competition.gameCategory
                this.description = competition.description
                this.updatedAt = LocalDateTime.now()
            }
        }
    }

    override fun updateCompany(company: Company): Company? {
        return company.id?.let {
            findCompanyOne(it)?.apply {
                this.name = company.name
                this.logo = company.logo
                this.updatedAt = LocalDateTime.now()
            }
        }
    }

}
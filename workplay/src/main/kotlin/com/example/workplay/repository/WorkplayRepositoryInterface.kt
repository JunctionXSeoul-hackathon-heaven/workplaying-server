package com.example.workplay.repository

import com.example.workplay.database.Company
import com.example.workplay.database.Competition
import com.example.workplay.database.User

interface WorkplayRepositoryInterface {

    // save
    fun saveUser(user: User): User
    //fun saveUserAll(userList: MutableList<User>): Boolean

    fun saveCompetition(competition: Competition): Competition
    //fun saveCompetitionAll(competitionList: MutableList<Competition>): Boolean

    fun saveCompany(company: Company): Company
    //fun saveCompanyAll(companyList: MutableList<Company>): Boolean


    // delete
    fun deleteUser(index: Int): Boolean
    fun deleteCompetition(index: Int): Boolean
    fun deleteCompany(index: Int): Boolean


    // find
    fun findUserOne(index: Int): User?
    fun findUserAll(): MutableList<User>

    fun findCompetitionOne(index: Int): Competition?
    fun findCompetitionAll(): MutableList<Competition>

    fun findCompanyOne(index: Int): Company?
    fun findCompanyAll(): MutableList<Company>


    // update
    fun updateUser(user: User): User?
    fun updateCompetition(competition: Competition): Competition?
    fun updateCompany(company: Company): Company?
}
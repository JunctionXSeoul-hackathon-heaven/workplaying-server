package com.example.workplay.database

data class WorkplayDatabase(
    var userIndex: Int = 0,
    var userList: MutableList<User> = mutableListOf(),

    var competitionIndex: Int = 0,
    var competitionList: MutableList<Competition> = mutableListOf(),

    var companyIndex: Int = 0,
    var companyList: MutableList<Company> = mutableListOf()
) {
    fun init() {
        this.userIndex = 0
        this.userList = mutableListOf()

        this.competitionIndex = 0
        this.competitionList = mutableListOf()

        this.companyIndex = 0
        this.companyList = mutableListOf()

        println("[DEBUG] Workplay Database Init")
    }
}
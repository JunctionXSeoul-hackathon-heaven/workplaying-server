package com.example.workplay.controller.api.workplay

import com.example.workplay.model.http.CompanyDto
import com.example.workplay.model.http.CompetitionDto
import com.example.workplay.model.http.UserDto
import com.example.workplay.service.WorkplayService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class WorkplayApiController(
    val workplayService: WorkplayService
) {
//    @GetMapping(path=["/user"])
//    fun readUser(@RequestParam index:Int): UserDto? {
//        return workplayService.readUser(index)
//    }
//
//    @GetMapping(path=["/user/all"])
//    fun readUserAll(): MutableList<UserDto> {
//        return workplayService.readAllUser()
//    }


    // user CRUD
    @GetMapping(path=["/user"])
    fun readUser(@RequestParam(required=false, name="id") index:Int?): Any? {
        if(index == null)
            return workplayService.readAllUser()
        return workplayService.readUser(index)
    }

    @PostMapping(path=["/user"])
    fun createUser(@Valid @RequestBody userDto: UserDto): UserDto {
        return workplayService.createUser(userDto)
    }

    @PutMapping(path=["/user"])
    fun updateUser(@Valid @RequestBody userDto: UserDto): UserDto? {
        println(userDto)
        return workplayService.updateUser(userDto)
    }

    @DeleteMapping(path=["/user/{index}"])
    fun deleteUser(@PathVariable(name="index") _index:Int): ResponseEntity<Any> {
        if(!workplayService.deleteUser(_index))
            return ResponseEntity.status(500).build()

        return ResponseEntity.ok().build()
    }

    // join
    @PostMapping(path=["/join/user/{userId}/competition/{competitionId}"])
    fun joinCompetition(
        @PathVariable userId: Int,
        @PathVariable competitionId: Int
    ): Boolean {
        return workplayService.join(userId, competitionId)
    }


    // cancel
    @PostMapping(path=["/cancel/user/{userId}/competition/{competitionId}"])
    fun cancelCompetition(
        @PathVariable userId: Int,
        @PathVariable competitionId: Int
    ): Boolean {
        return workplayService.cancel(userId, competitionId)
    }

    // competition CRUD
    @GetMapping(path=["/competition"])
    fun readCompetition(@RequestParam(required=false, name="id") index:Int?): Any? {
        if(index == null)
            return workplayService.readAllCompetition()
        return workplayService.readCompetition(index)
    }

    @PostMapping(path=["/competition"])
    fun createCompetition(@Valid @RequestBody competitionDto: CompetitionDto): CompetitionDto {
        return workplayService.createCompetition(competitionDto)
    }

    @PutMapping(path=["/competition"])
    fun updateCompetition(@Valid @RequestBody competitionDto: CompetitionDto): CompetitionDto? {
        return workplayService.updateCompetition(competitionDto)
    }

    @DeleteMapping(path=["/competition/{index}"])
    fun deleteCompetition(@PathVariable(name="index") _index:Int): ResponseEntity<Any> {
        if(!workplayService.deleteCompetition(_index))
            return ResponseEntity.status(500).build()

        return ResponseEntity.ok().build()
    }

    // Company CRUD
    @GetMapping(path=["/company"])
    fun readCompany(@RequestParam(required=false, name="id") index:Int?): Any? {
        if(index == null)
            return workplayService.readAllCompany()
        return workplayService.readCompany(index)
    }

    @PostMapping(path=["/company"])
    fun createCompany(@Valid @RequestBody companyDto: CompanyDto): CompanyDto {
        return workplayService.createCompany(companyDto)
    }

    @PutMapping(path=["/company"])
    fun updateCompany(@Valid @RequestBody companyDto: CompanyDto): CompanyDto? {
        return workplayService.updateCompany(companyDto)
    }

    @DeleteMapping(path=["/company/{index}"])
    fun deleteCompany(@PathVariable(name="index") _index:Int): ResponseEntity<Any> {
        if(!workplayService.deleteCompany(_index))
            return ResponseEntity.status(500).build()

        return ResponseEntity.ok().build()
    }


}
package com.hipo.summerintern.members.domain.model

data class Member(
    val name: String,
    val birthYear: Int,
    val location: String,
    val githubUsername: String,
    val employeeDetail: EmployeeDetail
)

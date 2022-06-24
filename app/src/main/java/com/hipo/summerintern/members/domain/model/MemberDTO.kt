package com.hipo.summerintern.members.domain.model

data class MemberDTO(
    val name: String,
    val birthYear: Int,
    val location: String,
    val githubUsername: String,
    val position: String,
    val startYear: Int
)

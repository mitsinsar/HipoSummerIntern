package com.hipo.summerintern.members.domain.mapper

import com.hipo.summerintern.members.domain.model.Member
import com.hipo.summerintern.members.domain.model.MemberDTO
import javax.inject.Inject

class MemberMapper @Inject constructor(
    private val employeeDetailMapper: EmployeeDetailMapper
) {

    fun mapToMember(memberDTO: MemberDTO): Member {
        return with(memberDTO) {
            Member(
                name = name,
                birthYear = birthYear,
                location = location,
                githubUsername = githubUsername,
                employeeDetail = employeeDetailMapper.mapToEmployeeDetail(
                    position = position,
                    startYear = startYear
                )
            )
        }
    }
}

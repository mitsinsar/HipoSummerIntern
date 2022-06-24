package com.hipo.summerintern.members.data.mapper

import com.hipo.summerintern.members.data.model.entity.MemberEntity
import com.hipo.summerintern.members.domain.model.MemberDTO
import javax.inject.Inject

class MemberDTOMapper @Inject constructor() {

    fun mapToMemberDTO(entity: MemberEntity): MemberDTO {
        return with(entity) {
            MemberDTO(
                name = name,
                birthYear = birthYear,
                location = location,
                githubUsername = githubUsername,
                position = position,
                startYear = startYear
            )
        }
    }

    fun mapToMemberEntity(dto: MemberDTO): MemberEntity {
        return with(dto) {
            MemberEntity(
                githubUsername = githubUsername,
                name = name,
                birthYear = birthYear,
                location = location,
                position = position,
                startYear = startYear
            )
        }
    }
}

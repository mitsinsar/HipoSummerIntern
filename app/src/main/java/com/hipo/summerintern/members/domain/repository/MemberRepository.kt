package com.hipo.summerintern.members.domain.repository

import com.hipo.summerintern.members.domain.model.MemberDTO
import kotlinx.coroutines.flow.Flow

interface MemberRepository {

    suspend fun getMemberList(): Flow<List<MemberDTO>>

    // TODO getMemberDetail(githubUsername: String): MemberDetailDTO

    // TODO saveMemberDetail(member: MemberDTO)

    companion object {
        const val INJECTION_NAME = "memberRepositoryInjectionName"
    }
}

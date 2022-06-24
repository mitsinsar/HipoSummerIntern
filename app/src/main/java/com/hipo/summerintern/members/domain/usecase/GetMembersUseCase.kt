package com.hipo.summerintern.members.domain.usecase

import com.hipo.summerintern.members.domain.mapper.MemberMapper
import com.hipo.summerintern.members.domain.model.Member
import com.hipo.summerintern.members.domain.repository.MemberRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Named

class GetMembersUseCase @Inject constructor(
    @Named(MemberRepository.INJECTION_NAME)
    private val memberRepository: MemberRepository,
    private val memberMapper: MemberMapper
) {

    suspend fun getMembers(): Flow<List<Member>> {
        return memberRepository.getMemberList().map { memberDtoList ->
            memberDtoList.map { memberDTO ->
                memberMapper.mapToMember(memberDTO)
            }
        }
    }
}

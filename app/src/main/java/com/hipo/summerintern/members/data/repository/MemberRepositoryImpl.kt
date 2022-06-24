package com.hipo.summerintern.members.data.repository

import com.hipo.summerintern.members.data.dao.MemberDao
import com.hipo.summerintern.members.data.mapper.MemberDTOMapper
import com.hipo.summerintern.members.domain.model.MemberDTO
import com.hipo.summerintern.members.domain.repository.MemberRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class MemberRepositoryImpl(
    private val memberDao: MemberDao,
    private val memberDTOMapper: MemberDTOMapper
) : MemberRepository {

    override suspend fun getMemberList(): Flow<List<MemberDTO>> = withContext(Dispatchers.IO) {
        memberDao.getMembers().map { memberEntityList ->
            memberEntityList.map { memberEntity ->
                memberDTOMapper.mapToMemberDTO(memberEntity)
            }
        }
    }
}

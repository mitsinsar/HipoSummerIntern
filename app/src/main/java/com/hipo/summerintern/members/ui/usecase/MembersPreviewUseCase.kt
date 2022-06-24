package com.hipo.summerintern.members.ui.usecase

import com.hipo.summerintern.members.domain.usecase.GetMembersUseCase
import com.hipo.summerintern.members.ui.mapper.MemberListItemMapper
import com.hipo.summerintern.members.ui.mapper.MembersPreviewMapper
import com.hipo.summerintern.members.ui.model.MembersPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MembersPreviewUseCase @Inject constructor(
    private val getMembersUseCase: GetMembersUseCase,
    private val memberListItemMapper: MemberListItemMapper,
    private val membersPreviewMapper: MembersPreviewMapper
) {

    fun getInitialPreview(): MembersPreview = membersPreviewMapper.createInitialPreview()

    suspend fun getMemberListItems(): Flow<MembersPreview> {
        return getMembersUseCase.getMembers()
            .map { memberList ->
                memberList.map { member ->
                    memberListItemMapper.mapToMemberListItem(member)
                }
            }
            .map { memberListItems ->
                membersPreviewMapper.mapToMembersPreview(memberListItems)
            }
    }
}

package com.hipo.summerintern.members.ui.mapper

import com.hipo.summerintern.members.domain.model.Member
import com.hipo.summerintern.members.ui.model.MemberListItem
import javax.inject.Inject

class MemberListItemMapper @Inject constructor() {

    fun mapToMemberListItem(member: Member): MemberListItem {
        return MemberListItem(
            githubUsername = member.githubUsername,
            name = member.name
        )
    }
}

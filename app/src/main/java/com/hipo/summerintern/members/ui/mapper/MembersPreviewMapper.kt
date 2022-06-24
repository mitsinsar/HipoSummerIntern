package com.hipo.summerintern.members.ui.mapper

import com.hipo.summerintern.members.ui.model.MemberListItem
import com.hipo.summerintern.members.ui.model.MembersPreview
import javax.inject.Inject

class MembersPreviewMapper @Inject constructor() {

    fun createInitialPreview() = MembersPreview(emptyList())

    fun mapToMembersPreview(memberListItems: List<MemberListItem>): MembersPreview {
        return MembersPreview(memberListItems)
    }
}

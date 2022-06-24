package com.hipo.summerintern.members.ui.model

import android.os.Parcelable
import com.hipo.summerintern.utils.list.RecyclerListItem
import kotlinx.parcelize.Parcelize

@Parcelize
data class MemberListItem(
    val githubUsername: String,
    val name: String
) : RecyclerListItem, Parcelable {

    override fun areItemsTheSame(other: RecyclerListItem): Boolean {
        return other is MemberListItem && other.githubUsername == githubUsername
    }

    override fun areContentsTheSame(other: RecyclerListItem): Boolean {
        return other is MemberListItem && other == this
    }
}

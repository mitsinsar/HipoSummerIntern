package com.hipo.summerintern.members.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.hipo.summerintern.members.ui.model.MemberListItem
import com.hipo.summerintern.utils.list.BaseDiffUtil

class MembersAdapter(
    private val listener: MemberAdapterListener
) : ListAdapter<MemberListItem, MemberViewHolder>(BaseDiffUtil()) {

    private val memberClickListItem = MemberViewHolder.MemberClickListener { memberListItem ->
        listener.onMemberClick(memberListItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        return MemberViewHolder.create(parent, memberClickListItem)
    }

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    interface MemberAdapterListener {
        fun onMemberClick(memberListItem: MemberListItem)
    }
}

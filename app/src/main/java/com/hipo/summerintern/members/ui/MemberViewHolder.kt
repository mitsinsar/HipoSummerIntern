package com.hipo.summerintern.members.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hipo.summerintern.databinding.ItemMemberBinding
import com.hipo.summerintern.members.ui.model.MemberListItem

class MemberViewHolder(
    private val binding: ItemMemberBinding,
    private val listener: MemberClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(memberListItem: MemberListItem) {
        with(binding) {
            root.setOnClickListener { listener.onClick(memberListItem) }
            nameTextView.text = memberListItem.name
        }
    }

    fun interface MemberClickListener {
        fun onClick(member: MemberListItem)
    }

    companion object {
        fun create(parent: ViewGroup, listener: MemberClickListener): MemberViewHolder {
            val binding = ItemMemberBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return MemberViewHolder(binding, listener)
        }
    }
}

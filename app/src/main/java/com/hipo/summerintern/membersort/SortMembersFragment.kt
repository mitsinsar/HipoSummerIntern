package com.hipo.summerintern.membersort

import com.hipo.summerintern.R
import com.hipo.summerintern.core.fragment.BaseFragment
import com.hipo.summerintern.core.fragment.FragmentConfiguration
import com.hipo.summerintern.core.fragment.ToolbarConfiguration

class SortMembersFragment : BaseFragment(R.layout.fragment_sort_members) {

    private val toolbarConfiguration = ToolbarConfiguration(
        startIconResId = R.drawable.ic_arrow_back,
        startIconClick = ::navBack,
        titleResId = R.string.sort_members
    )

    override val fragmentConfiguration: FragmentConfiguration = FragmentConfiguration(toolbarConfiguration)
}

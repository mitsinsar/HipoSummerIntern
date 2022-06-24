package com.hipo.summerintern.addnewmember

import com.hipo.summerintern.R
import com.hipo.summerintern.core.fragment.BaseFragment
import com.hipo.summerintern.core.fragment.FragmentConfiguration
import com.hipo.summerintern.core.fragment.ToolbarConfiguration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNewMemberFragment : BaseFragment(R.layout.fragment_add_new_member) {

    private val toolbarConfiguration = ToolbarConfiguration(
        titleResId = R.string.add_new_member,
        startIconResId = R.drawable.ic_arrow_back,
        startIconClick = ::navBack
    )

    override val fragmentConfiguration: FragmentConfiguration = FragmentConfiguration(toolbarConfiguration)
}

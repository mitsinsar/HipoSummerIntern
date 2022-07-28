package com.hipo.summerintern.members.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.hipo.summerintern.R
import com.hipo.summerintern.core.fragment.BaseFragment
import com.hipo.summerintern.core.fragment.FragmentConfiguration
import com.hipo.summerintern.core.fragment.ToolbarConfiguration
import com.hipo.summerintern.databinding.FragmentMembersBinding
import com.hipo.summerintern.members.ui.model.MemberListItem
import com.hipo.summerintern.members.ui.model.MembersPreview
import com.hipo.summerintern.utils.lifecycle.observe
import com.hipo.summerintern.utils.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.FlowCollector

class MembersFragment : BaseFragment(R.layout.fragment_members) {

    private val toolbarConfiguration = ToolbarConfiguration(
        titleResId = R.string.members
    )

    override val fragmentConfiguration: FragmentConfiguration = FragmentConfiguration(toolbarConfiguration)

    private val binding by viewBinding(FragmentMembersBinding::bind)

    private val membersViewModel by viewModels<MembersViewModel>()

    private val membersPreviewCollector = FlowCollector<MembersPreview> { membersPreview ->
        initMembersPreview(membersPreview)
    }

    private val membersAdapterListener = object : MembersAdapter.MemberAdapterListener {
        override fun onMemberClick(memberListItem: MemberListItem) {
            navToMemberDetail(memberListItem)
        }
    }

    private val membersAdapter = MembersAdapter(membersAdapterListener)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        initObservers()
    }

    private fun initUi() {
        with(binding) {
            membersRecyclerView.adapter = membersAdapter
            addNewMemberButton.setOnClickListener { navToAddNewMember() }
            sortMembersButton.setOnClickListener { navToSortMembers() }
        }
    }

    private fun initObservers() {
        viewLifecycleOwner.observe {
            membersViewModel.membersPreviewFlow.collect(membersPreviewCollector)
        }
    }

    private fun navToAddNewMember() {
        nav(MembersFragmentDirections.actionMembersFragmentToAddNewMemberFragment())
    }

    private fun navToMemberDetail(memberListItem: MemberListItem) {
        nav(MembersFragmentDirections.actionMembersFragmentToMemberDetailFragment(memberListItem))
    }

    private fun navToSortMembers() {
        nav(MembersFragmentDirections.actionMembersFragmentToSortMembersFragment())
    }

    private fun initMembersPreview(membersPreview: MembersPreview) {
        membersAdapter.submitList(membersPreview.memberListItems)
    }
}

package com.hipo.summerintern.memberdetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.hipo.summerintern.R
import com.hipo.summerintern.core.fragment.BaseFragment
import com.hipo.summerintern.core.fragment.FragmentConfiguration
import com.hipo.summerintern.core.fragment.ToolbarConfiguration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MemberDetailFragment : BaseFragment(R.layout.fragment_member_detail) {

    private val toolbarConfiguration = ToolbarConfiguration(
        startIconResId = R.drawable.ic_arrow_back,
        startIconClick = ::navBack
    )

    override val fragmentConfiguration: FragmentConfiguration = FragmentConfiguration(toolbarConfiguration)

    private val memberDetailViewModel by viewModels<MemberDetailViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        configureToolbar()
    }

    private fun configureToolbar() {
        val toolbarTitle = memberDetailViewModel.getMemberName()
        getToolbar()?.setTitle(toolbarTitle)
    }
}

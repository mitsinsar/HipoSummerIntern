package com.hipo.summerintern.memberdetail

import androidx.lifecycle.SavedStateHandle
import com.hipo.summerintern.core.BaseViewModel
import com.hipo.summerintern.members.ui.model.MemberListItem
import com.hipo.summerintern.utils.getOrThrow
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MemberDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    private val memberListItem = savedStateHandle.getOrThrow<MemberListItem>(MEMBER_ITEM_KEY)

    fun getMemberName() = memberListItem.name

    companion object {
        private const val MEMBER_ITEM_KEY = "memberLstItem"
    }
}

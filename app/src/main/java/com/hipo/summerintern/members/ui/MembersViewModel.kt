package com.hipo.summerintern.members.ui

import androidx.lifecycle.viewModelScope
import com.hipo.summerintern.core.BaseViewModel
import com.hipo.summerintern.members.ui.model.MembersPreview
import com.hipo.summerintern.members.ui.usecase.MembersPreviewUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class MembersViewModel @Inject constructor(
    private val MemberspreviewUseCase: MembersPreviewUseCase
) : BaseViewModel() {

    private val _membersPreviewFlow = MutableStateFlow<MembersPreview>(MemberspreviewUseCase.getInitialPreview())
    val membersPreviewFlow: StateFlow<MembersPreview>
        get() = _membersPreviewFlow

    init {
        initializeMembersPreviewFlow()
    }

    private fun initializeMembersPreviewFlow() {
        viewModelScope.launch {
            MemberspreviewUseCase.getMemberlisitems().collectLatest { membersPreview ->
                _membersPreviewFlow.value = membersPreview
            }
        }
    }
}

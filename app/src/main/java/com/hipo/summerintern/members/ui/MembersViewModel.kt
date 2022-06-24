package com.hipo.summerintern.members.ui

import androidx.lifecycle.viewModelScope
import com.hipo.summerintern.core.BaseViewModel
import com.hipo.summerintern.members.ui.model.MembersPreview
import com.hipo.summerintern.members.ui.usecase.MembersPreviewUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MembersViewModel @Inject constructor(
    private val membersPreviewUseCase: MembersPreviewUseCase
) : BaseViewModel() {

    private val _membersPreviewFlow = MutableStateFlow<MembersPreview>(membersPreviewUseCase.getInitialPreview())
    val membersPreviewFlow: StateFlow<MembersPreview>
        get() = _membersPreviewFlow

    init {
        initializeMembersPreviewFlow()
    }

    private fun initializeMembersPreviewFlow() {
        viewModelScope.launch {
            membersPreviewUseCase.getMemberListItems().collectLatest { membersPreview ->
                _membersPreviewFlow.value = membersPreview
            }
        }
    }
}

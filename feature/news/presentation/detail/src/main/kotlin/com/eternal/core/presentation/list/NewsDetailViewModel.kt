package com.eternal.core.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eternal.core.presentation.MVI
import com.eternal.core.presentation.list.NewsDetailContract.SideEffect
import com.eternal.core.presentation.list.NewsDetailContract.UiAction
import com.eternal.core.presentation.list.NewsDetailContract.UiState
import com.eternal.core.presentation.mvi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsDetailViewModel @Inject constructor() :
    ViewModel(),
    MVI<UiState, UiAction, SideEffect> by mvi(initialUiState = initialUiState()) {

    override fun onAction(uiAction: UiAction) {
        when (uiAction) {
            UiAction.OnDecreaseCountClick -> onDecreaseCountClick()
            is UiAction.OnIncreaseCountClick -> increaseCount(uiAction.amount)
        }
    }

    private fun increaseCount(amount: Int = 1) {
        updateUiState { copy(count = count + amount) }
    }

    private fun onDecreaseCountClick() {
        if (uiState.value.count > 0) {
            updateUiState { copy(count = count - 1) }
        } else {
            viewModelScope.emitSideEffect(SideEffect.ShowCountCanNotBeNegativeToast)
        }
    }
}

private fun initialUiState() = UiState(count = 0)

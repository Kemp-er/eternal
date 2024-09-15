package com.eternal.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eternal.core.presentation.MVI
import com.eternal.core.presentation.mvi
import com.eternal.home.presentation.HomeContract.SideEffect
import com.eternal.home.presentation.HomeContract.UiAction
import com.eternal.home.presentation.HomeContract.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() :
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

package com.eternal.feature.product.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eternal.core.presentation.MVI
import com.eternal.core.presentation.mvi
import com.eternal.feature.product.presentation.list.ProductListContract.SideEffect
import com.eternal.feature.product.presentation.list.ProductListContract.UiAction
import com.eternal.feature.product.presentation.list.ProductListContract.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor() :
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

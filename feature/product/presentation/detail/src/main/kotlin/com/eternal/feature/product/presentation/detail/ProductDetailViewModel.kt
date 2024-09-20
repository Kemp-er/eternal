package com.eternal.feature.product.presentation.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.eternal.core.presentation.MVI
import com.eternal.core.presentation.mvi
import com.eternal.feature.product.presentation.detail.ProductDetailContract.SideEffect
import com.eternal.feature.product.presentation.detail.ProductDetailContract.UiAction
import com.eternal.feature.product.presentation.detail.ProductDetailContract.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) :
    ViewModel(),
    MVI<UiState, UiAction, SideEffect> by mvi(initialUiState = initialUiState()) {

    val productId: String = savedStateHandle.toRoute<ProductRoute>().id

    override fun onAction(uiAction: UiAction) {
        when (uiAction) {
            UiAction.OnDecreaseCountClick -> onDecreaseCountClick()
            is UiAction.OnIncreaseCountClick -> increaseCount()
        }
    }

    private fun increaseCount() {
        updateUiState { copy() }
    }

    private fun onDecreaseCountClick() {
        updateUiState { copy() }
    }
}

private fun initialUiState() = UiState("0")

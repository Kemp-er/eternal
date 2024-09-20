package com.eternal.feature.product.presentation.detail

interface ProductDetailContract {
    data class UiState(val id: String)

    sealed interface UiAction {
        data class OnIncreaseCountClick(val amount: Int) : UiAction
        data object OnDecreaseCountClick : UiAction
    }

    sealed interface SideEffect {
        data object ShowCountCanNotBeNegativeToast : SideEffect
    }
}

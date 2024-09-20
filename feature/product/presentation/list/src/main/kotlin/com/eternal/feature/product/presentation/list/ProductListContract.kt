package com.eternal.feature.product.presentation.list

interface ProductListContract {
    data class UiState(
        val count: Int,
    )

    sealed interface UiAction {
        data class OnIncreaseCountClick(val amount: Int) : UiAction
        data object OnDecreaseCountClick : UiAction
    }

    sealed interface SideEffect {
        data object ShowCountCanNotBeNegativeToast : SideEffect
    }
}

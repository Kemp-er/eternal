package com.eternal.core.presentation.list

interface NewsDetailContract {
    data class UiState(val id: String)

    sealed interface UiAction {
        data class OnIncreaseCountClick(val amount: Int) : UiAction
        data object OnDecreaseCountClick : UiAction
    }

    sealed interface SideEffect {
        data object ShowCountCanNotBeNegativeToast : SideEffect
    }
}

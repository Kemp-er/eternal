package com.eternal.core.presentation.list

interface NewsListContract {
    data class UiState(
        val count: Int,
    )

    sealed interface UiAction {

    }

    sealed interface SideEffect {

    }
}

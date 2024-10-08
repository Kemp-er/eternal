package com.eternal.core.presentation.list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.eternal.core.presentation.MVI
import com.eternal.core.presentation.list.NewsDetailContract.SideEffect
import com.eternal.core.presentation.list.NewsDetailContract.UiAction
import com.eternal.core.presentation.list.NewsDetailContract.UiState
import com.eternal.core.presentation.mvi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) :
    ViewModel(),
    MVI<UiState, UiAction, SideEffect> by mvi(initialUiState = initialUiState()) {

    val newsRouteId: String = savedStateHandle.toRoute<NewsRoute>().id

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

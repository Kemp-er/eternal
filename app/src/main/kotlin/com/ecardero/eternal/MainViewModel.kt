package com.ecardero.eternal

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.Instant
import java.time.format.DateTimeFormatter
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {
    fun getTime(): String {
        return getDateTime()
    }

    private fun getDateTime(): String {
        val timestamp = System.currentTimeMillis() / 1000 // timestamp in Long

        val timestampAsDateString = DateTimeFormatter.ISO_INSTANT
            .format(Instant.ofEpochSecond(timestamp))

        return timestampAsDateString
    }
}

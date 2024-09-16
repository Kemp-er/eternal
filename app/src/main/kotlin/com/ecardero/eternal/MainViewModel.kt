package com.ecardero.eternal

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.Instant
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import kotlin.random.Random


@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {
    private val time = getRandom()

    fun getTime(): String {
        return time.toString()
    }

    private fun getRandom(): Int {
        return Random.nextInt(0, 100)
    }

    private fun getDateTime(): String {
        val timestamp = System.currentTimeMillis() / 1000

        val timestampAsDateString = DateTimeFormatter.ISO_INSTANT
            .format(Instant.ofEpochSecond(timestamp))

        return timestampAsDateString
    }
}

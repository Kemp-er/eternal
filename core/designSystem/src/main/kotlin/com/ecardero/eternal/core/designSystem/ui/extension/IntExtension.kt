package com.ecardero.eternal.core.designSystem.ui.extension

import android.content.Context
import com.ecardero.eternal.core.designSystem.R

private const val ONE = 1
private const val TWO = 2
private const val THREE = 3

fun Int.toOrdinal(context: Context): String {
    return when(this) {
        ONE -> context.resources.getString(R.string.ordinal_one, this)
        TWO -> context.resources.getString(R.string.ordinal_two, this)
        THREE -> context.resources.getString(R.string.ordinal_three, this)
        else -> context.resources.getString(R.string.ordinal_else, this)
    }
}

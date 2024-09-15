package com.ecardero.eternal

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App : Application() {
    companion object {
        const val STRATEGY_METHOD_COUNT = 2
        const val METHOD_OFFSET = 5
    }

    init {
        val formatStrategy =
            PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)
                .methodCount(STRATEGY_METHOD_COUNT)
                .methodOffset(METHOD_OFFSET)
                .tag("Eternal")
                .build()

        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
        Timber.plant(
            object : Timber.DebugTree() {
                override fun log(
                    priority: Int,
                    tag: String?,
                    message: String,
                    t: Throwable?,
                ) {
                    Logger.log(priority, tag, message, t)
                }
            },
        )

        Logger.d("Application Initialized.")
    }
}

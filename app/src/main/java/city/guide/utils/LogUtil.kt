package city.guide.utils

import android.util.Log

/**
 * Debugging Logs class
 * Created by vvdn on 23/6/18.
 */

private val isLogEnabled: Boolean = true

fun v(logTag: String, logMessageToPrint: String) {
    if (isLogEnabled)
        Log.v(logTag, logMessageToPrint)
}
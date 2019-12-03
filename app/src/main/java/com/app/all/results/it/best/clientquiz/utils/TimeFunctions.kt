package com.app.all.results.it.best.clientquiz.utils

object TimeFunctions {


    //<editor-fold desc="Here milliseconds convert to minute and seconds format">
    fun millisecondsToTime(milliseconds: Long): String {
        val minutes = milliseconds / 1000 / 60
        val seconds = milliseconds / 1000 % 60
        val secondsStr = java.lang.Long.toString(seconds)
        val secs: String
        if (secondsStr.length >= 2) {
            secs = secondsStr.substring(0, 2)
        } else {
            secs = "0$secondsStr"
        }
        return "$minutes:$secs"
    }
    //</editor-fold>
}
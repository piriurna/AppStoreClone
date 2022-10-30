package com.piriurna.common.extensions

import android.content.res.Resources
import android.util.TypedValue

fun Resources.getFloatDimension(dimensResourceId: Int): Float {
    val outValue = TypedValue()
    this.getValue(dimensResourceId, outValue, true)
    return outValue.float
}

fun Resources.getDimensionInDp(dimensResourceId: Int): Int {
    return (getDimension(dimensResourceId) / displayMetrics.density).toInt()
}
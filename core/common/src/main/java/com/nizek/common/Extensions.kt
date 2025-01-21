package com.nizek.common

import android.view.View


fun View.show() {
    this.apply {
        if (visibility != View.VISIBLE) {
            visibility = View.VISIBLE
        }
    }
}

fun View.hide() {
    this.apply {
        if (visibility != View.GONE) {
            visibility = View.GONE
        }
    }
}

package com.piriurna.common.helpers

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class HorizontalMarginItemDecoration(private val spaceSize: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        with(outRect) {
            if (parent.getChildAdapterPosition(view) != 0) {
                left = spaceSize
            }
            if(parent.getChildAdapterPosition(view) != parent.childCount - 1){
                right = spaceSize
            }
            top = spaceSize
            bottom = spaceSize
        }
    }
}
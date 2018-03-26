package com.yuganshtyagi.whatsapp_copy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by Yugansh Tyagi on 3/25/2018.
 */

public class SeparatorDecoration extends RecyclerView.ItemDecoration {

    private final Paint mPaint;

    public SeparatorDecoration(@NonNull Context context, @ColorInt int color,
                               @FloatRange(from = 0, fromInclusive = false) float heightDp) {
        mPaint = new Paint();
        mPaint.setColor(color);
        final float thickness = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                heightDp, context.getResources().getDisplayMetrics());
        mPaint.setStrokeWidth(thickness);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();

        // we want to retrieve the position in the list
        final int position = params.getViewAdapterPosition();

        // and add a separator to any view but the last one
        if (position < state.getItemCount()) {
            outRect.set(0, 0, 0, (int) mPaint.getStrokeWidth()); // left, top, right, bottom
        } else {
            outRect.setEmpty(); // 0, 0, 0, 0
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        // we set the stroke width before, so as to correctly draw the line we have to offset by width / 2
        final int offset = (int) (mPaint.getStrokeWidth() / 2);

        // this will iterate over every visible view
        for (int i = 0; i < parent.getChildCount(); i++) {
            // get the view
            final View view = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();

            // get the position
            final int position = params.getViewAdapterPosition();

            // and finally draw the separator
            if (position < state.getItemCount()) {
                c.drawLine(view.getLeft()+190, view.getBottom() + offset, view.getRight()-30, view.getBottom() + offset, mPaint);
            }
        }
    }
}

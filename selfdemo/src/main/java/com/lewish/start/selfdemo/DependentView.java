package com.lewish.start.selfdemo;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2016/10/29 16:58.
 */
public class DependentView extends View {
    private int lastX;
    private int lastY;

    public DependentView(Context context) {
        super(context);
    }

    public DependentView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                CoordinatorLayout.MarginLayoutParams marginLayoutParams = (CoordinatorLayout.MarginLayoutParams) getLayoutParams();
                int left = (int) (marginLayoutParams.leftMargin + x - lastX);
                int top = (int) (marginLayoutParams.topMargin + y - lastY);
                marginLayoutParams.leftMargin = left;
                marginLayoutParams.topMargin = top;
                setLayoutParams(marginLayoutParams);
                requestLayout();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        lastX = x;
        lastY = y;
        return true;
    }
}

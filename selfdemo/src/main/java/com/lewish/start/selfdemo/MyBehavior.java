package com.lewish.start.selfdemo;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/10/31 10:39.
 */

public class MyBehavior extends CoordinatorLayout.Behavior<TextView> {
    private int width;
    public MyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        DisplayMetrics display = context.getResources().getDisplayMetrics();
        width = display.widthPixels;
    }

    /**
     * 判断child布局是否依赖
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        return dependency instanceof DependentView;
    }

    /**
     * 当Dependency发生改变时执行这个函数，返回true表示位置改变，返回false表示位置不改变
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
        CoordinatorLayout.MarginLayoutParams childMarginLayoutParams= (ViewGroup.MarginLayoutParams) child.getLayoutParams();

        int top = dependency.getTop();
        int left = dependency.getLeft();

        childMarginLayoutParams.leftMargin = width - left - child.getWidth();
        childMarginLayoutParams.topMargin = top;

        child.setLayoutParams(childMarginLayoutParams);
        return true;
    }
}

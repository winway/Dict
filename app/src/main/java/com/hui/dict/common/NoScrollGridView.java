package com.hui.dict.common;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * @PackageName: com.hui.dict.common
 * @ClassName: NoScrollGridView
 * @Author: winwa
 * @Date: 2023/2/27 8:18
 * @Description:
 **/
public class NoScrollGridView extends GridView {

    public NoScrollGridView(Context context) {
        super(context);
    }

    public NoScrollGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}

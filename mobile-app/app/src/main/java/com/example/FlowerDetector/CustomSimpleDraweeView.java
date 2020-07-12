package com.example.FlowerDetector;

import android.content.Context;
import android.util.AttributeSet;

import com.facebook.drawee.view.SimpleDraweeView;

public class CustomSimpleDraweeView extends SimpleDraweeView {
    public CustomSimpleDraweeView(Context context) {
        super(context);
    }

    public CustomSimpleDraweeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomSimpleDraweeView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth()); // snap to width
    }
}

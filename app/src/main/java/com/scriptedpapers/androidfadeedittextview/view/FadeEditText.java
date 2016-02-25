package com.scriptedpapers.androidfadeedittextview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by mahes on 1/25/16.
 */
public class FadeEditText extends EditText{

    int horiz;

    public int textColor = 0xFF000000;

    public FadeEditText(Context context) {
        super(context);

    }

    public FadeEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FadeEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int horiz, int vert, int oldHoriz, int oldVert) {
        super.onScrollChanged(horiz, vert, oldHoriz, oldVert);

        this.horiz = horiz;
        requestLayout();
    }

    @Override
    public void onDraw(Canvas canvas) {

        int width = getMeasuredWidth();

        textColor = getCurrentTextColor();

        if(getText() != null && getText().length() > 1 && getLayout().getLineWidth(0) > width) {

            int widthRight = getMeasuredWidth() + horiz;
            int percent = getMeasuredWidth() * 20 / 100;

            int widthPreLeft = horiz;
            int widthLeft = horiz;

            float stopRight = 0;
            float stopLeft = 0;

            float stopPreLeft = (float) widthPreLeft / (float) widthRight;

            if (widthPreLeft > 0)
                stopLeft = (float) (widthLeft + percent) / (float) widthRight;

            if (getLayout().getLineWidth(0) > widthRight)
                stopRight = ((float) (widthRight - percent) / (float) widthRight);
            else
                stopRight = ((float) (widthRight) / (float) widthRight);

            LinearGradient gradient = new LinearGradient(0, 0, widthRight, 0,
                    new int[]{textColor, Color.TRANSPARENT, textColor, textColor, Color.TRANSPARENT},
                    new float[]{0, stopPreLeft, stopLeft, stopRight, 1.0f},
                    Shader.TileMode.CLAMP);

            getPaint().setShader(gradient);
        } else {

            getPaint().setShader(null);
        }

        super.onDraw(canvas);
    }

}


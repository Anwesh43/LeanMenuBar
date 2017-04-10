package com.anwesome.ui.leanmenubar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by anweshmishra on 10/04/17.
 */
public class MenuBar extends View {
    private int color = Color.parseColor("#00BCD4");
    private MenuButton menuButton;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int time = 0;
    private OnMenuButtonClickListener onMenuButtonClickListener;
    public void setOnMenuButtonClickListener(OnMenuButtonClickListener onMenuButtonClickListener) {
        this.onMenuButtonClickListener = onMenuButtonClickListener;
    }
    private boolean isAnimated = false;
    public void setColor(int color) {
        this.color = color;
    }
    public MenuBar(Context context) {
        super(context);
    }
    public void onDraw(Canvas canvas) {
        if(time == 0) {
            int w = canvas.getWidth(), h = canvas.getHeight();
            menuButton = new MenuButton(4*w/5,h/2,Math.max(w,h)/25);
        }
        canvas.drawColor(color);
        menuButton.draw(canvas,paint);
        time++;
        if(isAnimated) {
            menuButton.update();
            if(menuButton.stop()) {
                isAnimated = false;
                if(onMenuButtonClickListener!=null) {
                    if (menuButton.opened()) {
                        onMenuButtonClickListener.onOpen();
                    }
                    else {
                        onMenuButtonClickListener.onClose();
                    }
                }
            }
            try {
                Thread.sleep(50);
                invalidate();
            }
            catch (Exception ex) {

            }
        }
    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN && !isAnimated) {
            if(menuButton.handleTap(event.getX(),event.getY())) {
                isAnimated = true;
                postInvalidate();
            }
        }
        return true;
    }
    public interface OnMenuButtonClickListener {
        void onOpen();
        void onClose();
    }
}

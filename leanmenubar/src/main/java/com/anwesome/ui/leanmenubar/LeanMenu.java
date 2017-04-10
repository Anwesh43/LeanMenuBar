package com.anwesome.ui.leanmenubar;

import android.graphics.*;

/**
 * Created by anweshmishra on 10/04/17.
 */
public class LeanMenu {
    private String option;
    private MenuClickListener clickListener;
    private float x,y,w,h,scale = 0,dir = 0;
    public LeanMenu(String option,MenuClickListener clickListener) {
        this.option = option;
        this.clickListener = clickListener;
    }
    public void setDimension(float x,float y,float w,float h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    public void draw(Canvas canvas, Paint paint) {
        canvas.save();
        canvas.translate(x,y);
        paint.setColor(Color.parseColor("#E0E0E0"));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(new RectF(-w/2,-h/2,w/2,h/2),paint);
        paint.setTextSize(w/2);
        paint.setColor(Color.BLACK);
        canvas.drawText(option,w/2-paint.measureText(option)/2,h/2-paint.getTextSize()/2,paint);
        canvas.save();
        canvas.scale(scale,scale);
        paint.setColor(Color.parseColor("#99424242"));
        canvas.drawRect(new RectF(-w/2,-h/2,w/2,h/2),paint);
        canvas.restore();
        canvas.restore();
    }
    public boolean handleTap(float x,float y) {
        boolean condition  = x>=this.x && x<=this.x+w && y>=this.y && y<=this.y+h && dir == 0;
        if(condition) {
            dir = 1;
        }
        return condition;
    }
    public void update() {
        scale+=dir*0.1f;
        if(scale>=1) {
            dir = -1;
        }
        if(scale<=0) {
            dir = 0;
            scale = 0;
            if(clickListener!=null) {
                clickListener.onMenuClick();
            }
        }
    }
    public int hashCode() {
        return (int)(y)+option.hashCode();
    }
    public interface MenuClickListener {
        void onMenuClick();
    }
    public boolean stop() {
        return dir == 0;
    }
}

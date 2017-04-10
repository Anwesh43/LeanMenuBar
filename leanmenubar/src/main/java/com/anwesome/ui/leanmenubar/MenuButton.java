package com.anwesome.ui.leanmenubar;

import android.graphics.*;

/**
 * Created by anweshmishra on 10/04/17.
 */
public class MenuButton {
    private float x,y,r,newR,deg = 0,dir = 0;
    public MenuButton(float x,float y,float r) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.newR = r/7;
    }
    public void draw(Canvas canvas, Paint paint) {
        canvas.save();
        canvas.translate(x,y);
        canvas.rotate(deg);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(r/40);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(0,0,r,paint);
        paint.setStyle(Paint.Style.FILL);
        float newx = -r/2+3*newR/2;
        for(int i=0;i<3;i++) {
            canvas.drawCircle(newx,0,newR,paint);
            newx+=2*r;
        }
        canvas.restore();
    }
    public void update() {
        deg+=dir;
        if(deg>=90 || deg<=0) {
            dir = 0;
        }
    }
    public boolean handleTap(float x,float y) {
        boolean condition = x>=this.x-r && x<=this.x+r && y>=this.y-r && y<=this.y+r;
        if(condition) {
            dir = deg == 0?1:-1;
        }
        return condition;
    }
    public int hashCode() {
        return (int)(x+y+dir+deg);
    }
    public boolean stop() {
        return  dir == 0;
    }
    public boolean opened() {
        return deg>=90;
    }
}

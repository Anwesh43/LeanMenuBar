package com.anwesome.ui.leanmenubar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 10/04/17.
 */
public class LeanMenuContainer extends View{
    private List<LeanMenu> leanMenuList = new ArrayList<>();
    private LeanMenu selectedMenu = null;
    private int time = 0;
    private boolean isAnimated = false;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public LeanMenuContainer(Context context) {
        super(context);
    }
    public void setLeanMenus(List<LeanMenu> leanMenus) {
        this.leanMenuList = leanMenus;
    }
    public void onDraw(Canvas canvas) {
        int w = canvas.getWidth(),h = canvas.getHeight();
        initMenus(w,h);
        drawMenus(canvas,paint);
        time++;
        animateSelectedMenu();
    }
    public void initMenus(int w,int h) {
        if(time == 0) {
            int y = 0;
            for(LeanMenu leanMenu:leanMenuList) {
                leanMenu.setDimension(0,y,w,h/(leanMenuList.size()));
                y+=(h/leanMenuList.size());
            }
        }
    }
    public void drawMenus(Canvas canvas, Paint paint) {
        for(LeanMenu leanMenu:leanMenuList) {
            leanMenu.draw(canvas,paint);
        }
    }
    public void animateSelectedMenu() {
        if(isAnimated) {
            selectedMenu.update();
            if(selectedMenu.stop()) {
                isAnimated = false;
                selectedMenu = null;
            }
            try {
                Thread.sleep(50);
                invalidate();
            }
            catch(Exception ex) {

            }
        }
    }
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX(),y = event.getY();
        if(event.getAction() == MotionEvent.ACTION_DOWN && !isAnimated) {
            for(LeanMenu leanMenu:leanMenuList) {
                if(leanMenu.handleTap(x,y)) {
                    selectedMenu = leanMenu;
                    break;
                }
            }
            if(selectedMenu!=null) {
                isAnimated = true;
                postInvalidate();
            }
        }
        return true;
    }
}

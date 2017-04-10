package com.anwesome.ui.leanmenubar;

import android.app.Activity;
import android.graphics.Point;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 10/04/17.
 */
public class MenuBarController {
    private Activity activity;
    private MenuBar menuBar;
    private LeanMenuContainer leanMenuContainer;
    private boolean shown = false;
    private List<LeanMenu> leanMenus = new ArrayList<>();
    private MenuBarController(Activity activity) {
        this.activity = activity;
    }
    public void addLeanMenu(LeanMenu leanMenu) {
        if(!shown) {
            this.leanMenus.add(leanMenu);
        }
    }
    private void createAndAddViews() {
        Point size = DimensionUtil.getDimension(activity);
        int w = size.x, h = size.y;
        menuBar = new MenuBar(activity);
        leanMenuContainer = new LeanMenuContainer(activity);
        leanMenuContainer.setLeanMenus(leanMenus);
        if (activity instanceof AppCompatActivity) {
            ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
            actionBar.hide();
        } else {
            android.app.ActionBar actionBar = activity.getActionBar();
            actionBar.hide();
        }
        activity.addContentView(leanMenuContainer, new ViewGroup.LayoutParams(w / 3, w / 3 * leanMenus.size()));
        leanMenuContainer.setX(4 * w / 5 - w / 10 - w / 3);
        leanMenuContainer.setY(h / 30);
        leanMenuContainer.setVisibility(View.INVISIBLE);
        activity.addContentView(menuBar, new ViewGroup.LayoutParams(w, h / 5));
        menuBar.setX(4 * w / 5);
        menuBar.setY(0);

    }
    public void show() {
        if(!shown) {
            createAndAddViews();
            shown = true;
        }
    }
}

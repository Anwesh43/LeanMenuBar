package com.anwesome.ui.leanmenubar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.view.Display;

/**
 * Created by anweshmishra on 10/04/17.
 */
public class DimensionUtil {
    public static Point getDimension(Activity activity) {
        Point dimension = new Point();
        DisplayManager displayManager = (DisplayManager) activity.getSystemService(Context.DISPLAY_SERVICE);
        Display display = displayManager.getDisplay(0);
        display.getRealSize(dimension);
        return dimension;
    }
}

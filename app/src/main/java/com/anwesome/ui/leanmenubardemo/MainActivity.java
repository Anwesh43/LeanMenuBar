package com.anwesome.ui.leanmenubardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.anwesome.ui.leanmenubar.LeanMenu;
import com.anwesome.ui.leanmenubar.MenuBarController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LeanMenu leanMenu1 = new LeanMenu("Hello", new LeanMenu.MenuClickListener() {
            @Override
            public void onMenuClick() {
                Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
            }
        });
        LeanMenu leanMenu2 = new LeanMenu("Hi", new LeanMenu.MenuClickListener() {
            @Override
            public void onMenuClick() {
                Toast.makeText(MainActivity.this, "Hi", Toast.LENGTH_SHORT).show();
            }
        });
        LeanMenu leanMenu3 = new LeanMenu("Score", new LeanMenu.MenuClickListener() {
            @Override
            public void onMenuClick() {
                Toast.makeText(MainActivity.this, "Score", Toast.LENGTH_SHORT).show();
            }
        });
        MenuBarController menuBarController = new MenuBarController(this);
        menuBarController.addLeanMenu(leanMenu1);
        menuBarController.addLeanMenu(leanMenu2);
        menuBarController.addLeanMenu(leanMenu3);
        menuBarController.show();
    }
}

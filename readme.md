## LeanMenuBar

### Android library to add lean menu bar in activity

### Usage


#### Adding the library in the activity
```
    dependencies {
        compile project(':leanmenubar')
    }
```


#### Creating MenuBarController in Activity

```
    MenuBarController menuBarController = new MenuBarController(this);
```

#### Creating LeanMenu by using a option string and menuclicklistener

```
    LeanMenu leanMenu = new LeanMenu("Hello", new LeanMenu.MenuClickListener() {
        @Override
        public void onMenuClick() {
            Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
        }
    });
```

#### Adding LeanMenu in MenuBarController

```
    menuBarController.addLeanMenu(leanMenu);
```

#### Showing MenuBarController

```
    menuBarController.show();
```


### Demo

<img src="https://github.com/Anwesh43/LeanMenuBar/blob/master/screenshots/leanmenubar.gif" width="400px" height="700px" alt="screencast of demo">

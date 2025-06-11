package com.yarovyi.app.ui.menuHandling;

import com.yarovyi.app.ui.util.Console;
import io.github.bohdanyarovyi.cli.menu.handler.MenuHandler;

public class SimpleMenuHandler extends MenuHandler {

    @Override
    public String getUserInput() {
        return Console.getUserInput();
    }

}

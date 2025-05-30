package com.yarovyi.app.cli.menu;

import com.yarovyi.app.cli.action.commandManagement.CommandRegister;
import com.yarovyi.app.cli.menu.handler.MenuHandler;
import com.yarovyi.app.cli.menu.handler.SimpleMenuHandler;
import com.yarovyi.app.cli.action.operationManagement.OperationRegister;
import com.yarovyi.app.context.AppContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleMenu implements Menu {
    private final String menuName;
    private final List<Menu> submenus;
    private final CommandRegister commandRegister;
    private final OperationRegister operationRegister;
    private final MenuHandler menuHandler;
    private boolean isRunning;

    public SimpleMenu(String menuName, AppContext context) {
        this(
                menuName,
                new ArrayList<>(),
                new CommandRegister(context),
                new OperationRegister(context),
                new SimpleMenuHandler()
        );
    }

    public SimpleMenu(String menuName, List<Menu> submenus,
                      CommandRegister commandRegister,
                      OperationRegister operationRegister,
                      MenuHandler menuHandler) {
        this.menuName = menuName;
        this.submenus = submenus;
        this.commandRegister = commandRegister;
        this.operationRegister = operationRegister;
        this.menuHandler = menuHandler;
    }

    @Override
    public void addSubmenu(Menu submenu) {
        this.submenus.add(submenu);
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public void setRunning(boolean running) {
        this.isRunning = running;
    }

    @Override
    public String getMenuName() {
        return this.menuName;
    }

    @Override
    public MenuHandler getMenuHandler() {
        return this.menuHandler;
    }

    @Override
    public OperationRegister getOperationRegister() {
        return this.operationRegister;
    }

    @Override
    public CommandRegister getCommandRegister() {
        return this.commandRegister;
    }

    @Override
    public List<Menu> getSubmenus() {
        return Collections.unmodifiableList(this.submenus);
    }

}

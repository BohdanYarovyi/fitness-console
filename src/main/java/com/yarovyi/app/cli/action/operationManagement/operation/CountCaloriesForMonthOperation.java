package com.yarovyi.app.cli.action.operationManagement.operation;

import com.yarovyi.app.context.AppContext;

public class CountCaloriesForMonthOperation extends Operation {
    private AppContext appContext;


    @Override
    public void doOperation() {
        System.out.println("CountCaloriesForMonthOperation");
//        throw new UnsupportedOperationException();
    }

    @Override
    public String getOperationDescription() {
        return "Show calories for month";
    }

    @Override
    public String getOperationPattern() {
        return "/caloriesForMonth";
    }

    @Override
    public void setApplicationContext(AppContext context) {
        this.appContext = context;
    }

}

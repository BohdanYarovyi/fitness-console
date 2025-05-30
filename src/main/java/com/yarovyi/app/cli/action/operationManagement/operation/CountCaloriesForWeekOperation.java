package com.yarovyi.app.cli.action.operationManagement.operation;

import com.yarovyi.app.context.AppContext;

public class CountCaloriesForWeekOperation extends Operation {
    private AppContext appContext;


    @Override
    public void doOperation() {
        System.out.println("CountCaloriesForWeekOperation");
//        throw new UnsupportedOperationException();
    }

    @Override
    public String getOperationDescription() {
        return "Show calories for week";
    }

    @Override
    public String getOperationPattern() {
        return "/caloriesForWeek";
    }

    @Override
    public void setApplicationContext(AppContext context) {
        this.appContext = context;
    }

}

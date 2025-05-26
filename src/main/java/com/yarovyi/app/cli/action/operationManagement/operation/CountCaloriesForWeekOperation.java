package com.yarovyi.app.cli.action.operationManagement.operation;

public class CountCaloriesForWeekOperation extends Operation {

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

}

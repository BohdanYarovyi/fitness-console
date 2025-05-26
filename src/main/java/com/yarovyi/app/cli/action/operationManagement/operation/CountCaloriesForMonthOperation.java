package com.yarovyi.app.cli.action.operationManagement.operation;

public class CountCaloriesForMonthOperation extends Operation {

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

}

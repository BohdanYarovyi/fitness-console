package com.yarovyi.app.cli.action.operationManagement.operation;

public class ShowAllWorkoutsOperation extends Operation {

    @Override
    public void doOperation() {
        System.out.println("ShowAllWorkoutsOperation");
//        throw new UnsupportedOperationException();
    }

    @Override
    public String getOperationDescription() {
        return "Show all workouts";
    }

    @Override
    public String getOperationPattern() {
        return "/showWorkouts";
    }

}

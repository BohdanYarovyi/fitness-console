package com.yarovyi.app.cli.action.operationManagement.operation;

public class DeleteWorkoutOperation extends Operation {

    @Override
    public void doOperation() {
        System.out.println("DeleteWorkoutOperation");
//        throw new UnsupportedOperationException();
    }

    @Override
    public String getOperationDescription() {
        return "Delete workout";
    }

    @Override
    public String getOperationPattern() {
        return "/deleteWorkout";
    }

}

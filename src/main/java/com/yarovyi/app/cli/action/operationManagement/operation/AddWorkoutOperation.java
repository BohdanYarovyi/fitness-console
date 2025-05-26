package com.yarovyi.app.cli.action.operationManagement.operation;

public class AddWorkoutOperation extends Operation {

    @Override
    public void doOperation() {
        System.out.println("AddWorkoutOperation");
//        throw new UnsupportedOperationException();
    }

    @Override
    public String getOperationDescription() {
        return "Add WorkoutMenu";
    }

    @Override
    public String getOperationPattern() {
        return "/addWorkout";
    }

}

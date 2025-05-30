package com.yarovyi.app.cli.action.operationManagement.operation;

import com.yarovyi.app.cli.consoleConstant.ConsoleMessageTemplates;
import com.yarovyi.app.context.AppContext;
import com.yarovyi.app.entity.Workout;

import java.util.List;

import static com.yarovyi.app.cli.consoleConstant.ConsoleMessageTemplates.FORMAT_WORKOUT;

public class ShowAllWorkoutsOperation extends Operation {
    private AppContext appContext;

    @Override
    public void doOperation() {
        String view = getAllWorkoutsView();
        System.out.println(view);
    }

    @Override
    public String getOperationDescription() {
        return "Show all workouts";
    }

    @Override
    public String getOperationPattern() {
        return "/showWorkouts";
    }

    @Override
    public void setApplicationContext(AppContext context) {
        this.appContext = context;
    }

    // todo: it is maybe better to move in ConsoleMessageTemplates
    private String getAllWorkoutsView() {
        List<Workout> allWorkouts = appContext.getWorkoutRepository().getAllWorkouts();
        StringBuilder result = new StringBuilder();

        if (!allWorkouts.isEmpty()) {
            String itemSeparator = "|-\n";

            for (Workout workout : allWorkouts) {
                String item = FORMAT_WORKOUT.apply(workout);
                result.append(item)
                        .append(itemSeparator);
            }
            result.delete(result.length() - itemSeparator.length() + 1, result.length());

            return result.toString();
        } else {
            return "No one workout found";
        }
    }

}

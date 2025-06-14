package com.yarovyi.app.ui.operation;

import com.yarovyi.app.repository.WorkoutRepository;
import com.yarovyi.app.entity.Workout;
import io.github.bohdanyarovyi.cli.action.operationManagement.Operation;
import io.github.bohdanyarovyi.cli.context.AppContext;

import java.util.List;

import static com.yarovyi.app.ui.consoleConstant.ConsoleMessageTemplates.FORMAT_WORKOUT;

public class ShowAllWorkoutsOperation extends Operation {

    @Override
    public void doOperation(String[] args) {
        String view = getAllWorkoutsView();
        System.out.println(view);
    }

    @Override
    public String getDescription() {
        return "Show all workouts";
    }

    @Override
    public String getPattern() {
        return "/showWorkouts";
    }

    // todo: it is maybe better to move in ConsoleMessageTemplates
    private String getAllWorkoutsView() {
        AppContext context = getApplicationContext();
        WorkoutRepository workoutRepository = context.getComponent("workoutRepository", WorkoutRepository.class);

        List<Workout> allWorkouts = workoutRepository.getAllWorkouts();
        StringBuilder result = new StringBuilder();

        if (!allWorkouts.isEmpty()) {
            String itemSeparator = "|-\n";

            for (Workout workout : allWorkouts) {
                String item = FORMAT_WORKOUT.apply(workout);
                result.append(item)
                        .append(itemSeparator);
            }
            result.delete(result.length() - itemSeparator.length() - 1, result.length());

            return result.toString();
        } else {
            return "No one workout found";
        }
    }

}

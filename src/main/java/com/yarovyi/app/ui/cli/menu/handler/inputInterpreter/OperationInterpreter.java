package com.yarovyi.app.ui.cli.menu.handler.inputInterpreter;

import com.yarovyi.app.ui.cli.menu.Menu;
import com.yarovyi.app.ui.cli.action.operationManagement.OperationRegister;
import com.yarovyi.app.ui.cli.action.operationManagement.Operation;

public class OperationInterpreter implements Interpreter {

    @Override
    public boolean canInterpret(String input, Menu menu) {
        return menu.getOperationRegister().isRegistered(input);
    }

    @Override
    public void interpret(String input, Menu menu) {
        OperationRegister operationRegister = menu.getOperationRegister();
        Operation operation = operationRegister.getOperation(input);

        String[] args = getArgs(operation, input);
        operation.doOperation(args);
    }

}

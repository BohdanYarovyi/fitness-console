package com.yarovyi.app.cli.menu.handler.interpreter;

import com.yarovyi.app.cli.menu.Menu;
import com.yarovyi.app.cli.action.operationManagement.OperationRegister;
import com.yarovyi.app.cli.action.operationManagement.operation.Operation;

public class OperationInterpreter implements Interpreter {

    @Override
    public boolean canInterpret(String input, Menu menu) {
        return menu.getOperationRegister().isRegistered(input);
    }

    @Override
    public void interpret(String input, Menu menu) {
        OperationRegister operationRegister = menu.getOperationRegister();
        Operation operation = operationRegister.getOperation(input);

        operation.doOperation();
    }

}

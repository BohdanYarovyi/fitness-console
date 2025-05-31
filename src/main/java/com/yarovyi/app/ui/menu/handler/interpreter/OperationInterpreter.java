package com.yarovyi.app.ui.menu.handler.interpreter;

import com.yarovyi.app.ui.menu.Menu;
import com.yarovyi.app.ui.action.operationManagement.OperationRegister;
import com.yarovyi.app.ui.action.operationManagement.operation.Operation;

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

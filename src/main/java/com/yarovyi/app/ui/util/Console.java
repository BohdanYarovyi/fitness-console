package com.yarovyi.app.ui.util;

import com.yarovyi.app.exception.UserInputNotValidException;

import java.util.Scanner;

import static com.yarovyi.app.ui.consoleConstant.ConsoleMessageTemplates.PRINT_CONSOLE_INPUT_PREFIX;
import static com.yarovyi.app.ui.consoleConstant.ConsoleMessageTemplates.PRINT_MESSAGE;

public class Console {

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        PRINT_CONSOLE_INPUT_PREFIX.accept(">>");

        return scanner.nextLine();
    }

    public static String getUserInputWithLabel(String label) {
        Scanner scanner = new Scanner(System.in);
        PRINT_CONSOLE_INPUT_PREFIX.accept(label);

        return scanner.nextLine();
    }

    public static boolean isUserSure(String message) throws UserInputNotValidException {
        PRINT_MESSAGE.accept(message);
        String userInput = getUserInputWithLabel("'yes' or 'no':").toLowerCase();

        if (userInput.equals("yes") || userInput.equals("no")) {
            return userInput.equals("yes");
        }
        throw new UserInputNotValidException("Expected 'yes' or 'no', but it is: " + userInput);
    }

}

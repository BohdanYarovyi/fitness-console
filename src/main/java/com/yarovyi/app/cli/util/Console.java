package com.yarovyi.app.cli.util;

import java.util.Scanner;

import static com.yarovyi.app.cli.consoleConstant.ConsoleMessageTemplates.PRINT_CONSOLE_INPUT_PREFIX;

public class Console {

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        PRINT_CONSOLE_INPUT_PREFIX.run();

        return scanner.nextLine();
    }

}

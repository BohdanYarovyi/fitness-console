package com.yarovyi.app.ui.util;

import com.yarovyi.app.exception.UserInputNotValidException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.YearMonth;

public class DateUtil {

    public static LocalDate parseDate(String stringDate) throws UserInputNotValidException {
        String[] dateNumbers = stringDate.split("\\.");

        if (dateNumbers.length != 3) {
            throw new UserInputNotValidException("Input not valid, use yyyy.mm.dd format: " + stringDate);
        }
        try {
            int year = Integer.parseInt(dateNumbers[0]);
            int month = Integer.parseInt(dateNumbers[1]);
            int day = Integer.parseInt(dateNumbers[2]);

            return LocalDate.of(year, month, day);
        } catch (NumberFormatException | DateTimeException e) {
            throw new UserInputNotValidException("Entered date not valid. Please use integers (yyyy.mm.dd) ");
        }
    }

    public static YearMonth parseYearMonth(String stringDate) throws UserInputNotValidException {
        String[] dateNumbers = stringDate.split("\\.");

        if (dateNumbers.length != 2) {
            throw new UserInputNotValidException("Input not valid, use yyyy.mm format: " + stringDate);
        }
        try {
            int year = Integer.parseInt(dateNumbers[0]);
            int month = Integer.parseInt(dateNumbers[1]);

            return YearMonth.of(year, month);
        } catch (NumberFormatException | DateTimeException e) {
            throw new UserInputNotValidException("Entered date not valid. Please use integers (yyyy.mm.dd) ");
        }
    }

}

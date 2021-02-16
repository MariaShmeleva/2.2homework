package com.company;

public class Main {

    public static void main(String[] args) {
        String number = "+7(903)45422 89";
        changeNumber(number);
        String [] actualResult = changeNumber(number);
        System.out.println(actualResult[0]);
        System.out.println(actualResult[1]);
    }

    public static String[] changeNumber(String number) {
        String result = "";
        boolean isChange = false;
        String message = "";
        if (number.contains("(") || number.contains(")") || number.contains(" ")) {
            result = number.replaceAll("[()\\s]", "");
            isChange = true;
            message += "В номере есть пробелы и/или скобки; ";
            number = result;
        }
        if (number.substring(0,2).equals("+7")) {
            result = number.replace("+7", "8");
            isChange = true;
            message += "Замена +7 на 8;";
            number = result;
        }
        if (number.length()!=11) {
            isChange = true;
            message += " Номер некорректный! Количество символов не равно 11;";
        }
        String[] changedResult = new String[2];
        if (isChange) {
            changedResult[0] = result;
            changedResult[1] = message;
        }
        else {
            changedResult[0] = number;
            changedResult[1] = "Не было изменений.";
        }
        return changedResult;

    }

}
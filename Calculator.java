import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.String;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);
    static Integer number1, number2;
    static char operation = ' ';
    static Integer result;
    // char[] under_char = new char[10];
    static char[] under_char1 = new char[10];
    static char[] under_char2 = new char[10];
    static int j = 0;

    public static void main(String[] args) {
        System.out.println("Задайте выражение");

        String userInput = scanner.nextLine();

        for (int i = 0; i < userInput.length(); i++) {

            if (operation != ' ') {
                under_char2[j] = userInput.charAt(i);
                j++;
            }
            if (userInput.charAt(i) == '+') {
                operation = '+';
            }
            if (userInput.charAt(i) == '-') {
                operation = '-';
            }
            if (userInput.charAt(i) == '*') {
                operation = '*';
            }
            if (userInput.charAt(i) == '/') {
                operation = '/';
            }
            if (operation == ' ')
                under_char1[i] = userInput.charAt(i);
        }

        if (operation == ' ') {
            // Выдать сообщение, что нет операнда( + - * /) и выйти из программы.
            System.out.println("В выражении нет операнда( + , -, *, / ) : " + userInput);
            return;
        }

        String s_num1 = new String(under_char1).trim();
        String s_num2 = new String(under_char2).trim();
        char c1 = check_token_format(s_num1);
        char c2 = check_token_format(s_num2);

        if (c1 == 'E') {
            // Выдать сообщение, что нет операнда( + - * /) и выйти из программы.
            System.out.println("Первая часть выражения не число  - " + s_num1);
            return;
        }

        if (c2 == 'E') {
            // Выдать сообщение, что нет операнда( + - * /) и выйти из программы.
            System.out.println("Вторая часть выражения не число  - " + s_num2);
            return;
        }

        if (c1 != c2) {
            System.out.println("Части выражения в разных числовых форматах  - ");
            return;
        }
        if (c1 == 'A') {
            number1 = Integer.valueOf(s_num1);
            number2 = Integer.valueOf(s_num2);

        } else {
            number1 = romanToNumber(s_num1);
            number2 = romanToNumber(s_num2);


        }


        result = switch (operation) {
            case '+' -> number1 + number2;
            case '-' -> number1 - number2;
            case '*' -> number1 * number2;
            case '/' -> number1 / number2;
            default -> throw new IllegalArgumentException("Unexpected value: " + operation);
        };

        if (c1 == 'A') {
            System.out.println(userInput + " = " + result.toString());
        } else {
            System.out.println(userInput + " = " + convertNumToRoman(Integer.parseInt(result.toString())));


        }
    }

    public static char check_token_format(String snum) {

        char c1;   // A- арабские цифры, R - римские, Е- ошибка
        try {
            Integer n1 = Integer.valueOf(snum);
            c1 = 'A';
        } catch (NumberFormatException e) {
            c1 = check_token_format_roman(snum);
        }

        return c1;
    }

    public static char check_token_format_roman(String snum) {
        char z1;
        z1 = switch (snum) {
            case "I" -> 'R';
            case "II" -> 'R';
            case "III" -> 'R';
            case "IV" -> 'R';
            case "V" -> 'R';
            case "VI" -> 'R';
            case "VII" -> 'R';
            case "VIII" -> 'R';
            case "IX" -> 'R';
            case "X" -> 'R';

            default -> 'E';
        };
        return z1;
    }

    private static Integer romanToNumber(String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return -1;
    }

    private static String convertNumToRoman(int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;
    }
}
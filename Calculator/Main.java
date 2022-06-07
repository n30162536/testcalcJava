import org.jetbrains.annotations.NotNull;
import java.util.*;
import java.util.InputMismatchException;
import java.util.Scanner;


class Main {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static char operation;
    static int result;

    public static void main(String[] args) {
        System.out.println("Введите выражение типа: 2+2 или два римских числа от I до X: [V+V]. Числа от 1 до 10 включительно : ");
//      Считываем строку userInput которую ввёл пользователь
        calc();
    }

    public static @NotNull String calc() {

            String userInput = scanner.nextLine();
//      Создаём пустой символьный массив длиной 10 символов: sym_char
            char[] sym_char = new char[10];
//      Заполняем символьный массив символами строки которую ввел пользователь и по ходу ловим знак операции
            for (int i = 0; i < userInput.length(); i++) {
                sym_char[i] = userInput.charAt(i);
                if (sym_char[i] == '+') {
                    operation = '+';
                }
                if (sym_char[i] == '-') {
                    operation = '-';
                }
                if (sym_char[i] == '*') {
                    operation = '*';
                }
                if (sym_char[i] == '/') {
                    operation = '/';
                }

            }
//NumberFormatException
            String sym_charString = String.valueOf(sym_char);
            String[] blacks = sym_charString.split("[+-/*]");
            String stable00 = blacks[0];
            String stable01 = blacks[1];
            String string03 = stable01.trim();
            number1 = romanToNumber(stable00);
            number2 = romanToNumber(string03);
            if (number1 < 0 && number2 < 0 || number1 > 10 && number2 > 10) {
                result = 0;
            } else {
                result = calculated(number1, number2, operation);
                String resultRoman = convertNumToRoman(result);
                System.out.println(resultRoman);
            }
        if (number1 < 0 && number2 < 0 || number1 > 10 && number2 > 10) {
            result = 0;
        } else
            number1 = Integer.parseInt(stable00);
            number2 = Integer.parseInt(string03);
            result = calculated(number1, number2, operation);
            String res = Integer.toString(result);
            System.out.println(result);
            return res;
    }


    private static String convertNumToRoman (int numArabian) {
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



    private static int romanToNumber (String roman) {
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

    public static int calculated (int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Only integer non-zero parameters allowed");

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Неверный знак операции");
        }
        return result;
    }
}
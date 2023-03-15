import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;
public class Main {
    static Scanner scan = new Scanner(System.in);
    static int var1, var2;
    static char operation;
    static int result;

    public static void main(String[] args) {
        System.out.println("Введите два числа : ");
        String userInput = scan.nextLine();
        char[] oper_char = new char[10];
        for (int i = 0; i < userInput.length(); i++) {
            oper_char[i] = userInput.charAt(i);
            if (oper_char[i] == '+') {
                operation = '+';
            }
            if (oper_char[i] == '-') {
                operation = '-';
            }
            if (oper_char[i] == '*') {
                operation = '*';
            }
            if (oper_char[i] == '/') {
                operation = '/';
            }
        }
        String oper_charString = String.valueOf(oper_char);
        String[] signs = oper_charString.split("[+-/*]");
        String stb0 = signs[0];
        String stb1 = signs[1];
        String strings = stb1.trim();
        var1 = Enum.convertRomanToArab(stb0);
        var2 = Enum.convertRomanToArab(strings);
        if (signs.length > 2
        )
            throw new ArrayIndexOutOfBoundsException("Не более двух операндов!");
        else
            signs = Arrays.copyOf(signs, 2);
        try {
            stb0 = signs[0].trim();
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }

        if (var1 < 0 && var2 < 0) {
            result = 0;
        } else {
            result = Enum.calc(var1, var2, operation);
            System.out.println("Результат RomanNum:");
            String resultRoman = Enum.convertNumToRoman(result);
            System.out.println(stb0 + " " + operation + " " + strings + " = " + resultRoman);
        }
        var1 = Enum.convertRomanToArab(stb0);
        if (var1 == -1) var1 = Integer.parseInt(stb0);
        var2 = Enum.convertRomanToArab(strings);
        if (var2 == -1) var2 = Integer.parseInt(strings);
        result = Enum.calc(var2, var2, operation);
        System.out.println("Результат ArabNum:");
        System.out.println(var1 + " " + operation + " " + var2 + " = " + result);

    }
}

class Enum {


    static String convertNumToRoman(int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };

        return roman[numArabian];
    }
    static int convertRomanToArab (String numRoman) {
        try {
            switch (numRoman) {
                case "I" -> {return 1;}
                case "II" -> {return 2;}
                case "III" -> {return 3;}
                case "IV" -> {return 4;}
                case "V" -> {return 5;}
                case "VI" -> {return 6;}
                case "VII" -> {return 7;}
                case "VIII" -> {return 8;}
                case "IX" -> {return 9;}
                case "X" -> {return 10;}
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException();
        } return -1;
    }


    public static int calc(int num1, int num2, char znak) {
        if (num1 <= 0 || num1 > 10 || num2 <= 0 || num2 > 10) throw new IllegalArgumentException("Число больше 10!");
        int result = 0;
        switch (znak) {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> {
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Допускаются только целые числа!");

                }
            }
            default -> throw new IllegalArgumentException("Не верный знак!");
        }
        return result;
    }
}
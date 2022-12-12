import java.util.Scanner;

class Сalculator {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите выражение");
            String input = scanner.nextLine();
            System.out.println(calc(input));
        }
    }

    public static String calc(String input) throws Exception {
        int num1, num2;
        String result;
        boolean isRoman;
        String[] operation = input.split("\s");
        if (operation.length > 3) { //todo сделать на 3 элемента по пробел
            throw new RuntimeException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else if (operation.length < 3) {
            throw new RuntimeException("Строка не является математической операцией");
        }
        if (Roman.isRoman(operation[0]) && Roman.isRoman(operation[2])) {
            num1 = Roman.convertToArabic(operation[0]);
            num2 = Roman.convertToArabic(operation[2]);
            isRoman = true;
        } else if (!Roman.isRoman(operation[0]) && !Roman.isRoman(operation[2])) {
            num1 = Integer.parseInt(operation[0]);
            num2 = Integer.parseInt(operation[2]);
            isRoman = false;
        } else {
            throw new RuntimeException("Используются одновременно разные системы счисления");
        }

        if (num1 > 10 || num2 > 10) {
            throw new RuntimeException("Числа далжны быть от 0 до 10");
        }
        int arabic = calcularion(num1, num2, operation[1]);
        if (isRoman) {
            if (arabic <= 0) {
                throw new RuntimeException("В римской системе нет отрицательных чисел");
            }
            result = Roman.convertToRoman(arabic);
        } else {
            result = String.valueOf(arabic);
        }
        return result;
    }


//    static String detectedOperation(String input) throws Exception {
//        if (input.contains("+")) return "+";
//        else if (input.contains("-")) return "-";
//        else if (input.contains("*")) return "*";
//        else if (input.contains("/")) return "/";
//        else throw new Exception("Строка не является математической операцией");
//
//    }

    static int calcularion(int num1, int num2, String oper) {
//        if (oper.equals("+")) return num1 + num2;
//        else if (oper.equals("-")) return num1 - num2;
//        else if (oper.equals("*")) return num1 * num2;
//        else return num1/num2;

        int z;
        switch (oper) {
            case "+":
                z = num1 + num2;
                break;
            case "-":
                z = num1 - num2;
                break;
            case "/":
                z = num1 / num2;
                break;
            case "*":
                z = num1 * num2;
                break;
            default:
                return z = Integer.parseInt(null);
        }
        return z;
    }

    class Roman {
        static String[] romanArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX",
                "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX",
                "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
                "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX",
                "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX",
                "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX",
                "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX",
                "LXX", "LXXI", "LXXII", "LXXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXXIX",
                "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX",
                "XC", "XCI", "XII", "XCIII", "XCIV", "XCV", "XCVI", "XVII", "XCVIII", "ХХIХ", "C"};


        static boolean isRoman(String val) {
            for (int i = 0; i < romanArray.length; i++) {
                if (val.equals(romanArray[i])) {
                    return true;
                }
            }
            return false;
        }

        static int convertToArabic(String roman) {
            for (int i = 0; i < romanArray.length; i++) {
                if (roman.equals(romanArray[i])) {
                    return i;
                }
            }
            return -1;
        }

        static String convertToRoman(int arabic) {
            return romanArray[arabic];
        }
    }
}
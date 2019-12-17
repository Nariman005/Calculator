import java.util.InputMismatchException;

public class Converter {

    public boolean checkArabic(String number) {
        for (int i = 1; i <= 10; i++) {
            if (number.equals(String.valueOf(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean checkRoman(String number) {
        switch (number) {
            case "I":
                return true;
            case "II":
                return true;
            case "III":
                return true;
            case "IV":
                return true;
            case "V":
                return true;
            case "VI":
                return true;
            case "VII":
                return true;
            case "VIII":
                return true;
            case "IX":
                return true;
            case "X":
                return true;
            default:
                throw new InputMismatchException("Неправильный ввод");
        }
    }

    public int toArabic(String number) {
        switch (number) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                throw new InputMismatchException("Неправильный ввод");
        }
    }

    public String toRoman(int number) {
        String roman = "";

        if (number < 0) {
            roman += "-";
            number *= -1;
        }

        if (number == 0) {
            return "0";
        }

        while (number >= 100) {
            roman += "C";
            number -= 100;
        }
        while (number >= 90) {
            roman += "XC";
            number -= 90;
        }
        while (number >= 50) {
            roman += "L";
            number -= 50;
        }
        while (number >= 40) {
            roman += "XL";
            number -= 40;
        }
        while (number >= 10) {
            roman += "X";
            number -= 10;
        }
        while (number >= 9) {
            roman += "IX";
            number -= 9;
        }
        while (number >= 5) {
            roman += "V";
            number -= 5;
        }
        while (number >= 4) {
            roman += "IV";
            number -= 4;
        }
        while (number >= 1) {
            roman += "I";
            number -= 1;
        }

        return roman;
    }

}
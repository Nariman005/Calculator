import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private int number1,number2;
    private char operation;
    private int result;
    private boolean isArabic;
    Converter converter = new Converter();

    public void run(){
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        data = data.toUpperCase();
        operation = findOperation(data);
        number1 = findNumber1(data);
        number2 = findNumber2(data);
        calculate();
    }

    private char findOperation(String data){
        if (data.contains("+") && !data.startsWith("+") && !data.endsWith("+")) {
            return '+';
        }
        else if (data.contains("-") && !data.startsWith("-") && !data.endsWith("-")) {
            return '-';

        }
        else if (data.contains("*") && !data.startsWith("*") && !data.endsWith("*")) {
            return '*';
        }
        else if (data.contains("/") && !data.startsWith("/") && !data.endsWith("/")) {
            return '/';
        }
        else throw new InputMismatchException("Неправильный ввод операции");
    }

    private int findNumber1(String data){
        String number = data.substring(0,data.indexOf(operation));
        if (converter.checkArabic(number)){
            isArabic=true;
            return Integer.valueOf(number);
        }
        else if (converter.checkRoman(number)) {
            isArabic=false;
            return converter.toArabic(number);
        }
        throw new InputMismatchException("Неправильный ввод ");

    }

    private int findNumber2(String data){
        String number = data.substring(data.indexOf(operation)+1);
        if (converter.checkArabic(number)){
            if (isArabic) {
                return Integer.valueOf(number);
            }
            throw new InputMismatchException("Разный формат");
        }
        else if (converter.checkRoman(number)) {
            if (!isArabic) {
                return converter.toArabic(number);
            }
            throw new InputMismatchException("Разный формат");
        }

        throw new InputMismatchException("Неправильный ввод");
    }

    private void calculate(){
        switch (operation){
            case '+' : result = number1 + number2; break;
            case '-' : result = number1 - number2; break;
            case '*' : result = number1 * number2; break;
            case '/' : result = number1 / number2; break;
        }

        if (isArabic){
            System.out.println(result);
        }
        else {
            System.out.println(converter.toRoman(result));
        }
    }
}
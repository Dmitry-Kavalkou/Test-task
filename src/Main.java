import java.io.IOException;
import java.util.*;
import java.lang.*;


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Для выполнения арифметической операции введите два числа разделенных знаком операции.");
        System.out.println("Числа и знаки операции отделить пробелом.");

        Scanner console = new Scanner(System.in);
        String inValue = console.nextLine();

        String inValue_1 = inValue.trim();      // Удаляем пробелы в начале и в конце строки
        String[] inValueArray = inValue_1.split(" "); // создаем массив строк

        String arabicNum = "1 2 3 4 5 6 7 8 9 10";
        String romanicNum = "I II III VI V VI VII VIII IX X";
        String arabicAndRomanicNum = "1 2 3 4 5 6 7 8 9 10 I II III VI V VI VII VIII IX X";
        String symbolsOper = "+ - * /";



        if (!arabicAndRomanicNum.contains(inValueArray[0]) || !arabicAndRomanicNum.contains(inValueArray[2]) ||
                !symbolsOper.contains(inValueArray[1]))
            throw new IOException();



        Calc calculator = new Calc(); // Создаем объект calculator из класса Calc

        if (inValueArray[0].equals("I") || inValueArray[0].equals("II") || inValueArray[0].equals("III") ||
               inValueArray[0].equals("IV") || inValueArray[0].equals("V") || inValueArray[0].equals("VI") ||
               inValueArray[0].equals("VII") || inValueArray[0].equals("VIII") || inValueArray[0].equals("IX") ||
              inValueArray[0].equals("X")) {

            if (!romanicNum.contains(inValueArray[2]))
                throw new IOException();

            calculator.calcRoman(inValueArray); // Запускаем метод calcRoman

        }
        else {

            if (!arabicNum.contains(inValueArray[0]) || !arabicNum.contains(inValueArray[2]))
                throw new IOException();

            calculator.calcArabic(inValueArray); // Запускаем метод calcArabic

        }
    }

}

        class Calc {

            void calcArabic(String[] inValueArray) {

                if (inValueArray[1].equals("+")) {
                    int a = Integer.parseInt(inValueArray[0]);
                    int b = Integer.parseInt(inValueArray[2]);
                    System.out.println("Ответ: " + (a + b));
                } // Сложение

                if (inValueArray[1].equals("-")) {
                    int a = Integer.parseInt(inValueArray[0]);
                    int b = Integer.parseInt(inValueArray[2]);
                    System.out.println("Ответ: " + (a - b));
                } // Вычитание

                if (inValueArray[1].equals("*")) {
                    int a = Integer.parseInt(inValueArray[0]);
                    int b = Integer.parseInt(inValueArray[2]);
                    System.out.println("Ответ: " + (a * b));
                } //Умножение

                if (inValueArray[1].equals("/")) {
                    int a = Integer.parseInt(inValueArray[0]);
                    int b = Integer.parseInt(inValueArray[2]);
                    System.out.println("Ответ: " + (a / b));
                } // Деление

            }  // Арабский калькулятор

            void calcRoman(String[] inValueArray) throws IOException {

                int a = 0;
                int b = 0;
                int result = 0;
                //String resultStr = " ";

                switch (inValueArray[0]) {
                    case "I":    a = 1; break;
                    case "II":   a = 2; break;
                    case "III":  a = 3; break;
                    case "IV":   a = 4; break;
                    case "V":    a = 5; break;
                    case "VI":   a = 6; break;
                    case "VII":  a = 7; break;
                    case "VIII": a = 8; break;
                    case "IX":   a = 9; break;
                    case "X":    a = 10; break;
                } // Конвертируем первый оператор в арабское число

                switch (inValueArray[2]) {
                    case "I":    b = 1; break;
                    case "II":   b = 2; break;
                    case "III":  b = 3; break;
                    case "IV":   b = 4; break;
                    case "V":    b = 5; break;
                    case "VI":   b = 6; break;
                    case "VII":  b = 7; break;
                    case "VIII": b = 8; break;
                    case "IX":   b = 9; break;
                    case "X":    b = 10; break;
                } // Конвертируем второй оператор в арабское число

                if (inValueArray[1].equals("+")) {
                    result = a + b;
                } // Сложение

                if (inValueArray[1].equals("-")) {
                    result = a - b;
                } // Вычитание

                if (inValueArray[1].equals("*")) {
                    result = a * b;
                } //Умножение

                if (inValueArray[1].equals("/")) {
                    result = a / b;
                } // Деление

                if (result <= 0)
                    throw new IOException(); // Проверка исключения на отрицательный результат

                if (result <= 10) {
                    System.out.println("Ответ: " + arabicToRoman(result));
                } // Конвертируем результат в арабские числа

                if (result > 10 && result <= 20){
                    result = result - 10;
                    System.out.println("Ответ: " + "X" + arabicToRoman(result));
                } // Конвертируем результат в арабские числа

                if (result > 20 && result <= 30){
                    result = result - 20;
                    System.out.println("Ответ: " + "XX" + arabicToRoman(result));
                } // Конвертируем результат в арабские числа

                if (result > 30 && result < 40){
                    result = result - 30;
                    System.out.println("Ответ: " + "XXX" + arabicToRoman(result));
                } // Конвертируем результат в арабские числа

                if (result >= 40 && result < 50){
                    result = result - 40;
                    System.out.println("Ответ: " + "XL" + arabicToRoman(result));
                } // Конвертируем результат в арабские числа

                if (result >= 50 && result < 60){
                    result = result - 50;
                    System.out.println("Ответ: " + "L" + arabicToRoman(result));
                } // Конвертируем результат в арабские числа

                if (result >= 60 && result < 70){
                    result = result - 60;
                    System.out.println("Ответ: " + "LX" + arabicToRoman(result));
                } // Конвертируем результат в арабские числа

                if (result >= 70 && result < 80){
                    result = result - 70;
                    System.out.println("Ответ: " + "LXX" + arabicToRoman(result));
                } // Конвертируем результат в арабские числа

                if (result >= 80 && result < 90){
                    result = result - 80;
                    System.out.println("Ответ: " + "LXXX" + arabicToRoman(result));
                } // Конвертируем результат в арабские числа

                if (result >= 90 && result < 100){
                    result = result - 90;
                    System.out.println("Ответ: " + "XC" + arabicToRoman(result));
                } // Конвертируем результат в арабские числа

                if (result == 100)                      // Конвертируем результат в арабские числа
                    System.out.println("Ответ: C");

            }  // Римский калькулятор

            String arabicToRoman(int result){
                String resultStr = " ";
                switch (result) {
                    case 1: resultStr = "I"; break;
                    case 2: resultStr = "II"; break;
                    case 3: resultStr = "III"; break;
                    case 4: resultStr = "IV"; break;
                    case 5: resultStr = "V"; break;
                    case 6: resultStr = "VI"; break;
                    case 7: resultStr = "VII"; break;
                    case 8: resultStr = "VIII"; break;
                    case 9: resultStr = "IX"; break;
                    case 10: resultStr = "X"; break;
                }
                return resultStr;
            } // Метод


}











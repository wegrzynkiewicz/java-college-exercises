/*
Napisz prosty kalkulator wykonujący operacje dodawania, odejmowania, mnożenia
dzielenia oraz operację modulo w zależności od wyboru użytkownika
*/

package pl.wegrzynkiewicz.wste_java.lab2.zd1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Wprowadź pierwszą liczbę rzeczywistą: ");
            double first = input.nextDouble();

            System.out.print("Wprowadź drugą liczbę rzeczywistą: ");
            double second = input.nextDouble();

            while (true) {
                System.out.print("Wybierz odpowiednie działanie na liczbach (+, -, *, /, %): ");
                String operation = input.next().substring(0, 1);

                double result;

                if (operation.equals("+")) {
                    result = first + second;
                } else if (operation.equals("-")) {
                    result = first - second;
                } else if (operation.equals("*")) {
                    result = first * second;
                } else if (operation.equals("/") && second > 0) {
                    result = first / second;
                } else if (operation.equals("/") && second == 0) {
                    System.out.println("Nie wolno dzielić przez zero.");
                    break;
                } else if (operation.equals("%") && second > 0) {
                    result = first % second;
                } else if (operation.equals("%") && second == 0) {
                    System.out.println("Nie wolno dzielić przez zero.");
                    break;
                } else {
                    System.out.println("Nie rozpoznano operatora.");
                    continue;
                }

                System.out.printf("Rozwiązanie: %f %s %f = %f\n", first, operation, second, result);
                break;
            }
            System.out.println("(Ctrl + C, aby przerwać).\n");
        }
    }
}

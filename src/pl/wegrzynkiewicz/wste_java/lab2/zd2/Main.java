/*
Lotto
*/

package pl.wegrzynkiewicz.wste_java.lab2.zd2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void printNumbers(ArrayList<Integer> numbers) {
        for (Integer number : numbers) {
            System.out.printf("%d ", number);
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {

        // Pobranie liczb
        Scanner input = new Scanner(System.in);
        String words[] = {"pierszą", "drugą", "trzecią", "czwartą", "piątą", "szóstą"};
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        for (String word : words) {
            while (true) {
                System.out.printf("Wprowadź %s liczbę z zakresu <1-50>: ", word);
                int number = input.nextInt();
                if (number < 1 || number > 50) {
                    System.out.println("Nieprawidłowa zakres");
                    continue;
                }
                if (inputs.indexOf(number) != -1) {
                    System.out.println("Wybrałeś już tą liczbę.");
                    continue;
                }
                inputs.add(number);
                break;
            }
        }

        // Wyświetlenie wybranych liczb
        System.out.println("\nWybrałeś liczby:");
        printNumbers(inputs);

        // Losowanie liczb
        Random random = new Random();
        ArrayList<Integer> lottoNumbers = new ArrayList<Integer>();
        for (int i = 6; i > 0; i--) {
            while (true) {
                int randomNumber = random.nextInt(49) + 1;
                if (lottoNumbers.indexOf(randomNumber) == -1) {
                    lottoNumbers.add(randomNumber);
                    break;
                }
            }
        }

        // Wyświetlenie wylosowanych liczb
        System.out.println("\nWylosowane liczby:");
        printNumbers(lottoNumbers);

        // Podsumowanie
        int selected = 0;
        for (Integer lottoNumber: lottoNumbers) {
            if (inputs.indexOf(lottoNumber) != -1) {
                selected++;
            }
        }
        if (selected > 0) {
            System.out.printf("\nUdało Ci się trafić %d liczby :D", selected);
        } else {
            System.out.println("\nNie trafiłeś ani jednej liczby");
        }
    }
}

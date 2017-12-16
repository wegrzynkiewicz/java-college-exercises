/*
Napisz zgodnie z zasadami programowania obiektowego program,
który oblicza pole prostokąta. Klasa powinna zawierać trzy metody:
• czytaj dane() — metoda umożliwia wprowadzenie do programu długości boków a i b z klawiatury.
W programie należy przyjąć, że a i b oraz zmienna pole są̨ typu double (rzeczywistego).
• oblicz_pole() — metoda oblicza pole prostokąta według wzoru pole = a*b.
• wyswietl_wynik() — metoda wyświetla długości boków a i b oraz wartość zmiennej pole w określonym formacie.
Dla zmiennych a i b oraz pole należy przyjąć format wyświetlania ich na ekranie z dwoma miejscami po przecinku.
Dla chętnych: zaimplementuj metody obliczające obwód prostokąta oraz długość przekątnej.
 */

package pl.wegrzynkiewicz.wste_java.lab3.zd2;

import java.util.Scanner;

class Rectangle {
    double a;
    double b;

    public Rectangle() {
        czytaj_dane();
    }

    public void czytaj_dane() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Wprowadź A: ");
        this.a = scanner.nextDouble();
        System.out.print("Wprowadź B: ");
        this.b = scanner.nextDouble();
    }

    public double oblicz_pole() {
        return this.a * this.b;
    }

    public void wyswietl_wynik() {
        System.out.format("A: %.2f\n", this.a);
        System.out.format("B: %.2f\n", this.b);
        System.out.format("Pole: %.2f", this.oblicz_pole());
    }
}

public class Main {
    public static void main(String[] args) {
        (new Rectangle()).wyswietl_wynik();
    }
}

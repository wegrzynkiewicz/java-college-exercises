/*
Zdefiniować kolejno:
• interfejs Pojazd z bezparametrową metodą jazda() , która nie zwraca wartości.
• zdefiniować abstrakcyjna klasę Samochod, która implementuje interfejs Pojazd
• zdefiniować klasy SamochodOsobowy oraz Autobus które dziedziczą po klasie 
Samochod i w ciele metody jazda() wyświetlają komunikat "jedzie samochód 
osobowy" dla klasy SamochodOsobowy oraz "jedzie autobus" dla klasy Autobus.
Napisać program który pobierze od użytkownika rodzaj samochodu (osobowy albo autobus),
utworzy nowy obiekt podanej klasy i wywoła na rzecz obiektu metodę jazda().
*/

package pl.wegrzynkiewicz.wste_java.lab3.zd3;

import java.util.Scanner;

interface Pojazd {
    public void jazda();
}

abstract class Samochod implements Pojazd{
}

class SamochodOsobowy extends Samochod{
    @Override
    public void jazda() {
        System.out.println("Jedzie samochód osbosowy");
    }
}

class Autobus extends Samochod{
    @Override
    public void jazda() {
        System.out.println("Jedzie autobus");
    }
}

public class Main {
    public static void main(String[] args) {
        Samochod samochod;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("Wprowadź (samochod|autobus): ");
            String command = scanner.next();
            if (command.equalsIgnoreCase("samochod")) {
                samochod = new SamochodOsobowy();
            } else if (command.equalsIgnoreCase("autobus")) {
                samochod = new Autobus();
            } else {
                continue;
            }
            break;
        }
        samochod.jazda();
    }
}

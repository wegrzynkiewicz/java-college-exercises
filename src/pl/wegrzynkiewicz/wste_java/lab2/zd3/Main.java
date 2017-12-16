/*
Walidator numeru PESEL
*/

package pl.wegrzynkiewicz.wste_java.lab2.zd3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PESEL {

    int checksum[] = {1, 3, 7, 9, 1, 3, 7 ,9 ,1 ,3};
    int centuries[] = {1900, 2000, 2100, 2200, 1800};
    String birthDate;
    String sex;

    public PESEL (String pesel) {
        if (pesel.length() != 11) {
            throw new IllegalArgumentException("Numer PESEL zawiera niewłaściwą ilość znaków");
        }

        Pattern regex = Pattern.compile("(?<year>\\d{2})(?<month>\\d{2})(?<day>\\d{2})\\d{3}(?<sex>\\d)(?<last>\\d)");
        Matcher matches = regex.matcher(pesel);
        if (!matches.find()) {
            throw new IllegalArgumentException("Numer PESEL zawiera niewłaściwe znaki");
        }

        int sum = 0;
        int position = 0;
        for (int weight : checksum) {
            int number = Integer.parseInt(pesel.substring(position, position + 1));
            sum += number * weight;
            position++;
        }

        sum %= 10;
        sum = 10 - sum;
        sum %= 10;

        int last = Integer.parseInt(matches.group("last"));

        if (sum != last) {
            throw new IllegalArgumentException("Suma kontrolna numeru PESEL jest niewłaściwa");
        }

        int day = Integer.parseInt(matches.group("day"));
        int year = Integer.parseInt(matches.group("year"));
        int month = Integer.parseInt(matches.group("month"));

        int century = month / 20;
        int yearBase = centuries[century];

        year = yearBase + year;
        month %= 20;

        this.sex = Integer.parseInt(matches.group("sex")) % 2 == 1 ? "Mężczyzna" : "Kobieta";
        this.birthDate = String.format("%04d-%02d-%02d", year, month, day);
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Wprowadź PESEL (np. 66060513256, 44462403056, 18081313382): ");
        try {
            PESEL pesel = new PESEL(input.next());
            System.out.printf("Data urodzenia: %s\n", pesel.birthDate);
            System.out.printf("Płeć: %s", pesel.sex);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

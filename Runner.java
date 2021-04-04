package spintek;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scYear = new Scanner(System.in);
        System.out.println("Please enter a year:(Any 4 number between 1000-9999, example 2313)");

        while (!scYear.hasNextInt()) {
            System.out.println("Input has to be a digit!");
            scYear.next();
        }

        Integer year = scYear.nextInt();
        System.out.println("Paydays and reminder dates for the year- " + year);

        AccountantHelper process = new AccountantHelper(year);

        new Writer(process.generateDates(), String.valueOf(year));

        Scanner exit = new Scanner(System.in);
        System.out.println("Press ENTER to exit.");
        while ((exit.nextLine( )).length( ) > 0) {
            System.out.println("Press ENTER to exit.");
        }
    }
}

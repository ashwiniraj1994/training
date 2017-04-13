package ashwini;

import java.util.Scanner;

/**
 * Created by ashwinirajasekar on 4/13/17.
 */
public class Squareofanumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number;
        System.out.println("Enter a number to be squared: ");
        number = scan.nextInt();
        int Square = number * number;
        System.out.println("Square of a number " + number + " is " + Square);
    }
}

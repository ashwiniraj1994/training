package ashwini;

import java.util.Scanner;

/**
 * Created by ashwinirajasekar on 4/10/17.
 */
public class PoundstoKilogram {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        double pounds;
        double kilograms;
        System.out.println("Enter the weight in pounds : ");
        pounds = scan.nextDouble();
        kilograms = (pounds) * 0.454;
        System.out.println("Weight in Kilogram is " + kilograms);
    }
}

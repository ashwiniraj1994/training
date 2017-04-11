package ashwini;

import java.util.Scanner;

/**
 * Created by ashwinirajasekar on 4/10/17.
 */
public class AreaTriangle {

    Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double base;
        double height;
        double area;
        System.out.println("Enter the base: ");
        base = scan.nextDouble();
        System.out.println("Enter the height: ");
        height = scan.nextDouble();
        area = (base * height)/2;
        System.out.println("Area of triangle is " + area);
    }
}

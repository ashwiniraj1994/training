package ashwini;

import java.util.Scanner;

/**
 * Created by ashwinirajasekar on 4/10/17.
 */
public class areacircle {
    public static void main(String args[]){
        double rad;
        double area;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the radius : ");
        rad = scan.nextDouble();
        area = 3.14 * rad * rad;
        System.out.println("Area of the circle is: " + area);
    }
}

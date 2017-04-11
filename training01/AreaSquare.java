package ashwini;

import java.util.Scanner;

/**
 * Created by ashwinirajasekar on 4/10/17.
 */
public class AreaSquare {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double side;
        double area;
        System.out.println("Enter the side of the square : ");
        side = scan.nextDouble();
        area = side * side;
        System.out.println("Area of a square is : " + area);
    }
}

package ashwini;

import java.util.Scanner;

/**
 * Created by ashwinirajasekar on 4/10/17.
 */
public class AreaRectangle {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        double length;
        double width;
        double area;
        System.out.println("Enter the length: ");
        length = scan.nextDouble();
        System.out.println("Enter the width: ");
        width = scan.nextDouble();
        area = length * width;
        System.out.println("The Area of a rectangle is: " + area);
    }
}

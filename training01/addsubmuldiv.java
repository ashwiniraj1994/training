package ashwini;

import java.util.Scanner;

/**
 * Created by ashwinirajasekar on 4/13/17.
 */
public class addsubmuldiv {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num1;
        int num2;
        System.out.println("Enter the first number : ");
        num1 = scan.nextInt();
        System.out.println("Enter the second number : ");
        num2 = scan.nextInt();
        System.out.println("Addition of two numbers");
        int sum = num1 + num2;
        System.out.println("Sum of the numbers is : " + sum);
        System.out.println("Subtraction of two numbers");
        int difference = num1 - num2;
        System.out.println("Difference of two numbers is : " + difference);
        System.out.println("Multiplication of two numbers");
        int product = num1 * num2;
        System.out.println("Product of the numbers is : " + product);
        System.out.println("Division of two numbers");
        int divide = num1 / num2;
        System.out.println("Division of the numbers is : " + divide);
        System.out.println("Modulo of two numbers");
        int modulo = num1 % num2;
        System.out.println("Modulo  of the numbers is : " + modulo);
    }
}

package com.Ashwini;

import java.util.Scanner;

/**
 * Created by ashwinirajasekar on 4/9/17.
 */
public class Evenorodd {
    public static void main(String[] args) {
        int c;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number to check whether it is odd or even : ");
        c = scan.nextInt();

        if (c % 2 == 0) {
            System.out.println("The given number " + c + " is even!");
        } else {
            System.out.println("The given number " + c + " is odd!");

        }
    }
}

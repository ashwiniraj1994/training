package com.Ashwini;

import java.util.Scanner;

/**
 * Created by ashwinirajasekar on 4/9/17.
 */
public class Largestofthreenumbers {
    public static void main(String[] args) {
        int x,y,z;
        System.out.println("Enter the 3 numbers :");
        Scanner scan = new Scanner(System.in);

        x = scan.nextInt();
        y = scan.nextInt();
        z = scan.nextInt();

        if(x > y && x > z) {
            System.out.println(x + " is the largest number");
        }
        else if(y > x && y > z) {
            System.out.println(y + " is the largest number");
        }
        else if(z > x && z > y) {
            System.out.println(z + " is the largest number");
        }
        else {
            System.out.println("The given numbers are not distinct");
        }

    }
}

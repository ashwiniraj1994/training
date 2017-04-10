package com.Ashwini;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the first string : ");
        String a = scan.nextLine();
        System.out.println("Enter the second string : ");
        String b = scan.nextLine();
        String c = a + b;
        System.out.println("The concatenated string is : " + c );

    }
}

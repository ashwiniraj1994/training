package com.Ashwini;

import java.util.Scanner;

/**
 * Created by ashwinirajasekar on 4/9/17.
 */
public class Quizapp {
    public static void main(String[] args) {
        int c = 0;
        Scanner scan = new Scanner(System.in);
        String in;
        System.out.println("Enter your name :");
        String name;
        name = scan.nextLine();
        System.out.println("What is the fastest animal in the world?");
        System.out.println("lion");
        System.out.println("cheetah");
        System.out.println("monkey");
        System.out.println("deer");
        System.out.println("Enter your result :");
        in = scan.nextLine();

        if (in.equalsIgnoreCase("cheetah")) {
            System.out.println("Correct");
            c++;
        } else {
            System.out.println("Wrong");
        }

        System.out.println("What is the nearest planet to sun?");
        System.out.println("Mercury");
        System.out.println("Earth");
        System.out.println("Venus");
        System.out.println("Pluto");
        System.out.println("Enter your result :");
        in = scan.nextLine();
        if (in.equalsIgnoreCase("mercury")) {
            System.out.println("Correct");
            c++;
        } else {
            System.out.println("Wrong");
        }

        System.out.println("What is the distant planet to the earth?");
        System.out.println("Mercury");
        System.out.println("Earth");
        System.out.println("Venus");
        System.out.println("Pluto");
        System.out.println("Enter your result :");
        in = scan.nextLine();

        if (in.equalsIgnoreCase("pluto")) {
            System.out.println("Correct");
            c++;
        } else {
            System.out.println("Wrong");
        }

        System.out.println("What is the ideal shape of a pizza?");
        System.out.println("Circle");
        System.out.println("Triangle");
        System.out.println("Square");
        System.out.println("Rectangle");
        System.out.println("Enter your result :");
        in = scan.nextLine();

        if (in.equalsIgnoreCase("circle")) {
            System.out.println("Correct");
            c++;
        } else {
            System.out.println("Wrong");
        }

        System.out.println("Who is the president of America?");
        System.out.println("Trump");
        System.out.println("Obama");
        System.out.println("Clinton");
        System.out.println("Osama");
        System.out.println("Enter your result :");
        in = scan.nextLine();

        if (in.equalsIgnoreCase("trump")) {
            System.out.println("Correct");
            c++;
        } else {
            System.out.println("Wrong");
        }

        System.out.println("Which team won the 2011 cricket world cup?");
        System.out.println("India");
        System.out.println("Australia");
        System.out.println("America");
        System.out.println("England");
        System.out.println("Enter your result :");
        in = scan.nextLine();

        if (in.equalsIgnoreCase("india")) {
            System.out.println("Correct");
            c++;
        } else {
            System.out.println("Wrong");
        }

        System.out.println("Which is the hottest place in the earth?");
        System.out.println("India");
        System.out.println("Ethiopia");
        System.out.println("America");
        System.out.println("England");
        System.out.println("Enter your result :");
        in = scan.nextLine();

        if (in.equalsIgnoreCase("ethiopia")) {
            System.out.println("Correct");
            c++;
        } else {
            System.out.println("Wrong");
        }

        System.out.println("Which is the coldest place in the earth?");
        System.out.println("India");
        System.out.println("Ethiopia");
        System.out.println("East Antarctica");
        System.out.println("England");
        System.out.println("Enter your result :");
        in = scan.nextLine();

        if (in.equalsIgnoreCase("East Antarctica")) {
            System.out.println("Correct");
            c++;
        } else {
            System.out.println("Wrong");
        }

        System.out.println("How many legs do butterflies have?");
        System.out.println("6");
        System.out.println("4");
        System.out.println("2");
        System.out.println("8");
        System.out.println("Enter your result :");
        in = scan.nextLine();

        if (in.equalsIgnoreCase("6")) {
            System.out.println("Correct");
            c++;
        } else {
            System.out.println("Wrong");
        }

        System.out.println("what is biggest state in US?");
        System.out.println("Alaska");
        System.out.println("Texas");
        System.out.println("Florida");
        System.out.println("Alabama");
        System.out.println("Enter your result :");
        in = scan.nextLine();

        if (in.equalsIgnoreCase("alaska")) {
            System.out.println("Correct");
            c++;
        } else {
            System.out.println("Wrong");
        }

        System.out.println(name + " got " + c + " correct out of 10");
        if (c >= 5) {
            System.out.println(name + " Congrats! You passed the quiz");
        } else {
            System.out.println(name + " Work hard! You can pass next time");
        }

    }
}

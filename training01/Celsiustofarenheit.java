package com.Ashwini;

import java.util.Scanner;

/**
 * Created by ashwinirajasekar on 4/9/17.
 */
public class Celsiustofarenheit {


        public static void main(String[] args) {
            float temprature;
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the temprature in Celsius : ");
            temprature = scan.nextInt();


            temprature = (((temprature * 9)/5) + 32);

            System.out.println("Temprature in Farenheit is : " + temprature);

        }
    }


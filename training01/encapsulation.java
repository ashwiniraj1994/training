package ashwini;

import java.util.Scanner;

/**
 * Created by ashwinirajasekar on 4/13/17.
 */
public class encapsulation {

        private String name;
        private int age;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        encapsulation obj = new encapsulation();
        System.out.println("Enter the name : ");
        obj.setName(scan.nextLine());
        System.out.println("Enter the age : ");
        obj.setAge(scan.nextInt());

            System.out.println(obj.getName());
            System.out.println(obj.getAge());

        }
    }



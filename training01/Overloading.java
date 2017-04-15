package ashwini;

/**
 * Created by ashwinirajasekar on 4/15/17.
 */
public class Overloading {
    public static void main(String args) {
        System.out.println("It is valid method but not the main method");
    }

    public void main() {
        System.out.println("It is also a valid mehod");
    }

    public static void main(String[] args) {
        System.out.println("This is the main method and it will be compiled and remaing are overloaded methods.");
    }
}

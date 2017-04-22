package ashwini;

/**
 * Created by ashwinirajasekar on 4/16/17.
 */
public class Stringe {
    public boolean stringcheck(String name) {
        int counter = 0;
        char tocheck = 'e';
        boolean value;
        for (int i = 0; i <= name.length() - 1; i++) {
            if (name.charAt(i) == tocheck) {
                counter++;
            }
        }
        if (counter <= 3) {
            value = true;
        } else {
            value = false;
        }
    return value;
    }

    public static void main(String[] args) {
        Stringe s = new Stringe();
        System.out.println(s.stringcheck("Hello"));
        System.out.println(s.stringcheck("Hellee"));
        System.out.println(s.stringcheck("Helleee"));
    }
}


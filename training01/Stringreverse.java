package ashwini;

/**
 * Created by ashwinirajasekar on 4/17/17.
 */
public class Stringreverse {
    public void stringreverse(String toreverse) {
        for(int i = toreverse.length() - 1;i >= 0;i--) {
            System.out.print(toreverse.charAt(i));
        }
    }

    public static void main(String[] args) {
        Stringreverse sr = new Stringreverse();
        sr.stringreverse("Ashwini");
        sr.stringreverse("Simbu ");
    }
}

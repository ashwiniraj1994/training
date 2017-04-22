package ashwini;

/**
 * Created by ashwinirajasekar on 4/22/17.
 */
public class Stringswap {
    public String stringswap(String toswap) {
        int length = toswap.length();
        if (length <= 1) {
            return toswap;
        } else {
            return toswap.charAt(length - 1) + toswap.substring(1,length - 1) + toswap.charAt(0);
        }
    }

    public static void main(String[] args) {
        Stringswap swap = new Stringswap();
        System.out.println(swap.stringswap("ashwini"));
        System.out.println(swap.stringswap("a"));
    }
}

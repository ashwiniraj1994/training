package ashwini;

/**
 * Created by ashwinirajasekar on 4/16/17.
 */
public class sum {
    public void sum(int x,int y) {
        if(x != y) {
            System.out.println("The two numbers are different");
            int sum = x + y;
            System.out.println("The numbers are different so we just sum the numbers and the sum is : " + sum );
        }
        else if(x == y) {
            System.out.println("The two numbers are same");
            int sum = x + y;
            int result = 2 * sum;
            System.out.println("The numbers are same so we sum the numbers and double it and the result is : " + result);
        }
    }

    public static void main(String[] args){
        sum sum = new sum();
        sum.sum(2,3);
        sum.sum(2,2);
        sum.sum(54,63);
        sum.sum(24,24);
    }
}

package messCode;

public class BitwiseTest {
    public static void main(String[] arg)
    {
        int n = 10;
        int shift = 1;
        System.out.print("n>>" + shift + " = " + (n>>shift));

        /*
            [var]>>[amount] shifts the location that the computer reads a primitive var to the right by a
            specific amount.Generally makes the value smaller
            [var]<<[amount] shifts the location that the computer reads a primitive var to the left by a
            specific amount. Generally makes the value bigger
            [var1]|[var2] conducts an "or" logic gate on the binary between primitive vars.
            [var1]&[var2] conducts an "and" logic gate on the binary between primitive vars.
         */
    }
}

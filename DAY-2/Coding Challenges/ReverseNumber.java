//Given an integer n, reverse its digits and return the reversed number.
//Ignore leading zeros in the reversed result

import java.util.*;
public class ReverseNumber{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter an integer");
        int n = sc.nextInt();

        int reversed = reverseNumber(n);
        System.out.println("Reversed number:" + reversed);
        sc.close();
    }

    public static int reverseNumber(int n){
        int rev = 0;
        // check for negative number
        boolean isNegative = n<0;

        //work with absolute value
        n=Math.abs(n);

        while(n>0){
            int digit = n%10;
            rev = rev * 10 + digit;
            n /= 10;
        }
        return isNegative ? -rev : rev;
    }
}
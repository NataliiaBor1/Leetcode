import javax.crypto.spec.PSource;
import java.util.HashSet;
import java.util.Set;

public class L202_HappyNumber {

    /*
        202. Happy Number
        https://leetcode.com/problems/happy-number/

        Write an algorithm to determine if a number n is happy.
        A happy number is a number defined by the following process:

        Starting with any positive integer, replace the number by the sum of the squares of its digits.
        Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
        Those numbers for which this process ends in 1 are happy.
        Return true if n is a happy number, and false if not.

        Example 1:
        Input: n = 19
        Output: true
        Explanation:
        1^2 + 9^2 = 82
        8^2 + 2^2 = 68
        6^2 + 8^2 = 100
        1^2 + 0^2 + 0^2 = 1

        Example 2:
        Input: n = 2
        Output: false
     */

    public boolean isHappy(int n) {  // wrong

        String s = String.valueOf(n);
        int sum = 0;
        boolean isHappy = false;

        while (!isHappy) {
            for (int i = 0; i < s.length(); i++) {
                sum += Math.pow((s.charAt(i) - '0'), 2);
                System.out.println(sum);
            }
            if (sum == 1) {
                isHappy = true;
                return true;
            }
        }

        return false;
    }

    public boolean isHappy1(int n) {

        Set<Integer> usedIntegers = new HashSet<>();
        while (true) {

            int sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n = n/10;
            }

            if (sum == 1) return true;
            n = sum;

            if (usedIntegers.contains(n)) {
                return false;
            }
            usedIntegers.add(n);
        }
    }

    public static void main(String[] args) {
        int n = 19;
        System.out.println(new L202_HappyNumber().isHappy(n));
        char num = '8';
        System.out.println(num - '0');


    }


}

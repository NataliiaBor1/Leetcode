import java.util.HashMap;
import java.util.Map;

public class L13_RomanToInteger {

    /*
        13. Roman to Integer

        https://leetcode.com/problems/roman-to-integer/

        Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

        Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
        For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II.
        The number 27 is written as XXVII, which is XX + V + II.

        Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not
         IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
          The same principle applies to the number nine, which is written as IX. There are six instances where
           subtraction is used:

        I can be placed before V (5) and X (10) to make 4 and 9.
        X can be placed before L (50) and C (100) to make 40 and 90.
        C can be placed before D (500) and M (1000) to make 400 and 900.
        Given a roman numeral, convert it to an integer.

        Example 1:
        Input: s = "III"
        Output: 3
        Explanation: III = 3.

        Example 2:
        Input: s = "LVIII"
        Output: 58
        Explanation: L = 50, V= 5, III = 3.

        Example 3:
        Input: s = "MCMXCIV"
        Output: 1994
        Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     */

    public int romanToInt(String s) {

        int result = 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i < s.length(); i++) {

            if (!map.containsKey(s.charAt(i))) return 0;

            if ((i + 1) < s.length()) {
                if (s.charAt(i) == 'I' && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X') ||
                        s.charAt(i) == 'X' && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C') ||
                        s.charAt(i) == 'C' && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                    int middleStep = map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
                    result += middleStep;
                    i++;
                    continue;
                }
            }
            result += map.get(s.charAt(i));
        }

        return result;
    }


    public int romanToInt1(String s) {

        int result = 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) return 0;

            int value = map.get(s.charAt(i));

            if (i < s.length() - 1 && value < map.get(s.charAt(i+1))) {
                result -= value;
            } else {
                result += value;
            }
        }

        return result;
    }


    public int romanToInt2(String s) {

        int sum = 0;

        for (int i = s.length()-1; i >= 0; i--) {
            int num = 0;
            switch (s.charAt(i)) {
                case 'I' -> num = 1;
                case 'V' -> num = 5;
                case 'X' -> num = 10;
                case 'L' -> num = 50;
                case 'C' -> num = 100;
                case 'D' -> num = 500;
                case 'M' -> num = 1000;
                default -> {return 0;}
            }

            if (4 * num < sum) {
                sum -= num;
            } else {
                sum += num;
            }
        }

        return sum;
    }


}

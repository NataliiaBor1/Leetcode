import java.util.Arrays;

public class L14_CommonPrefix {

    /*
        14. Longest Common Prefix

        https://leetcode.com/problems/longest-common-prefix/

        Write a function to find the longest common prefix string amongst an array of strings.
        If there is no common prefix, return an empty string "".

        Example 1:
        Input: strs = ["flower","flow","flight"]
        Output: "fl"
        Example 2:
        Input: strs = ["dog","racecar","car"]
        Output: ""
        Explanation: There is no common prefix among the input strings.

        Constraints:
        1 <= strs.length <= 200
        0 <= strs[i].length <= 200
        strs[i] consists of only lowercase English letters.
     */

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        System.out.println(Arrays.toString(strs));
        String result = "";
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < min) {
                min = strs[i].length();
            };
        }

        for (int i = 0; i < strs.length-2; i++) {
            for (int j = 0; j < min; j++) {
                if ((strs[i].charAt(j) == strs[i+1].charAt(j)) && (strs[i+1].charAt(j) == strs[i+2].charAt(j))) {

                    result += strs[i].charAt(j);
                }
            }
        }
        return result;
    }

    public static String longestCommonPrefix1(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int idx = 0;
        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String[] strs1 = {"aid","aderw","abc", "abcdemm"};

        System.out.println(longestCommonPrefix1(strs));
        System.out.println(longestCommonPrefix1(strs1));
    }
}

class Solution {
    public int maxDepth(String s) {

        int countOpen = 0;
        int countMax = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                countOpen++;
                }
            else if (s.charAt(i) == ')') {
                countMax = Math.max(countMax, countOpen);
                countOpen--;
            }
        }

        return countMax;
    }
}
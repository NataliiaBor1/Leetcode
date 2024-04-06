class Solution {
    public String minRemoveToMakeValid(String s) {
        int open = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
                sb.append(s.charAt(i));
            } else if (s.charAt(i) == ')' && open == 0) {
                continue;
                // do not append if first parenthesis is closed one
            } else if (s.charAt(i) == ')' && open > 0) {
                open--;
                sb.append(s.charAt(i));
            } else {
                sb.append(s.charAt(i));
            }
        }
        
        while (open > 0) {
                sb.deleteCharAt(sb.lastIndexOf("("));
                open--;
        }

        return sb.toString();
    }
}
class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (n == k) {
            // can remove all digits
            return "0";
        }
        
        int[] stack = new int[n];
        int stackTop = -1;
        int digitsRemoved = 0;
        int digit;

        for (int i = 0; i < n; i++) {
            digit = num.charAt(i) - '0';
            while (digitsRemoved < k && stackTop >= 0 && stack[stackTop] > digit) {
                // remove last digit in stack
                stackTop--;
                digitsRemoved++;
            }
            stackTop++;
            stack[stackTop] = digit;
            // System.out.println(Arrays.toString(stack));
            // System.out.println("stack top = " + stackTop);
            
        }
        
        if ( digitsRemoved < k) {
            stackTop -= k - digitsRemoved;
        }

        // construct result from stack
        int firstIdx = 0;
        while (firstIdx <= stackTop && stack[firstIdx] == 0) {
            firstIdx++;
        }
        if (firstIdx > stackTop) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = firstIdx; i <= stackTop; i++) {
            sb.append(stack[i]);
        }
        return sb.toString();
    }
}
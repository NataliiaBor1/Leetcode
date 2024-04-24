class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;
        
        return tribonacciHelper(n, memo);
    }
    
    private int tribonacciHelper(int n, int[] memo) {
        if (n == 0 || memo[n] != 0) return memo[n];
        
        memo[n] = tribonacciHelper(n - 1, memo) + tribonacciHelper(n - 2, memo) + tribonacciHelper(n - 3, memo);
        
        return memo[n];
    }
}
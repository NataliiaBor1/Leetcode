class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        
            int n = tickets.length;
            int[] queue = new int[n];
        
            for (int i = 0; i < n; i++) {
                queue[i] = tickets[i];
            }

            int time = 0;
            while (queue[k] > 0) {
                for (int i = 0; i < n; i++) {
                    if (queue[i] > 0) {
                        // Each person buys one ticket
                        queue[i]--;
                        time++;

                        if (i == k && queue[k] == 0) {
                            return time;
                        }
                    }
                }
            }
            return time;
        }
}
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        String start = "0000";
        
        if (dead.contains(start)) return -1;
        if (target.equals(start)) return 0;
        
        queue.offer(start);
        visited.add(start);
        
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                List<String> neighbors = getNeighbors(current);
                for (String neighbor : neighbors) {
                    if (neighbor.equals(target)) {
                        return depth;
                    }
                    if (!visited.contains(neighbor) && !dead.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return -1;
    }

    private List<String> getNeighbors(String lock) {
        List<String> result = new ArrayList<>();
        char[] arr = lock.toCharArray();
        for (int i = 0; i < 4; i++) {
            char c = arr[i];
            // Increment wheel digit
            arr[i] = c == '9' ? '0' : (char)(c + 1);
            result.add(new String(arr));
            arr[i] = c;  // reset to original
            // Decrement wheel digit
            arr[i] = c == '0' ? '9' : (char)(c - 1);
            result.add(new String(arr));
            arr[i] = c;  // reset to original
        }
        return result;
    }

}
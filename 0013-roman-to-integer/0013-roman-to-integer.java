class Solution {
    public int romanToInt(String s) {
       if (s == null || s.length() < 1 || s.length() > 15) return 0;

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

        if (result < 1 || result > 3999) return 0;

        return result;
        
    }
}
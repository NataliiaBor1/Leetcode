class Solution {
    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        int x1, y1, x2, y2;
        var list = new ArrayList<int[]>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    x1 = i;
                    x2 = i;
                    y1 = j;
                    y2 = j;
                    while (y2 < n && land[x2][y2] == 1) {
                        y2++;
                    }
                    y2--;
                    while (x2 < m && land[x2][y2] == 1) {
                        x2++;
                    }
                    x2--;
                    list.add(new int[] {x1, y1, x2, y2});
                    for (int k = x1; k <= x2; k++) {
                        for (j = y1; j <= y2; j++) {
                            land[k][j] = 0;
                        }
                    }
                }
            }
        }
        
        int[][] result = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}
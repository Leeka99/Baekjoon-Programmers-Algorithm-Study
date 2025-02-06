import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int len = sizes.length;
        int maxW = Integer.MIN_VALUE;
        int maxH = Integer.MIN_VALUE;
        
        for (int i = 0; i < len; i++) {
            int w = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);
            maxW = Math.max(maxW, w);
            maxH = Math.max(maxH, h);
        }
        return maxW * maxH;
    }
}
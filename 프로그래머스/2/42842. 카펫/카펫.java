class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        
        for (int h = 1; h <= total; h++) {
            if (total % h == 0) {
                int w = total / h;
                
                if (w >= h && yellow == (h - 2)*(w - 2)) {
                    return new int[]{w, h};
                } 
            }
        }
        return new int[0];
    }
}
import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int allCnt = brown + yellow;
        
        for (int i = 1; i < allCnt / 2; i++) {
            if (allCnt % i == 0) {
                int y = i;
                int x = allCnt / y;
                if (x >= y && (x * y) == allCnt && (x - 2) * (y - 2) == yellow) {
                answer[0] = x;
                answer[1] = y;
                break;
                }
            }        
        }
        return answer;
    }
}
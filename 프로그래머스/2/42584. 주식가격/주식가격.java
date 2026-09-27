import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int index = 0; index < prices.length; index++) {
            int cnt = 0;
            for (int i = index + 1; i < prices.length; i++) {
                if (prices[index] <= prices[i]) cnt += 1;
                else {
                    cnt += 1;
                    break;
                }
            }
            answer[index] = cnt;
        }
        return answer;
    }
}
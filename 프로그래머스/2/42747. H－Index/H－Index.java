import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int len = citations.length;
        boolean bool = true;
        for (int h = 1; h <= len; h++) {
            int cnt = 0;
            // 1. h번 이상 인용된 논문 있나?
            for (int i = 0; i < len; i++) {
                if (citations[i] >= h) cnt++;
            }
            // 2. h번 이상 인용된 논문의 개수가 h편 이상인가?
            if (cnt < h) bool = false; 
                
            // 3. h번 미만 인용된 논문의 개수가 h번 이하인가?
            if (!bool || len - cnt > h) bool = false;
                
            // 4. 모두 해당된다면 h값 변경
            if (bool) answer = h;
            
            else break;
        }
        
        return answer;
    }
}
import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        // 기준 길이 설정
        for (int i = 1; i < s.length() / 2 + 1; i++) {
            String temp = "";
            String pre = s.substring(0, i);
            int cnt = 1;
            // 기준 길이로 자르기
            for (int j = i; j < s.length(); j += i) {
                String next = "";
                // 다음 문자열 계산
                for (int k = j; k < j + i; k++) {
                    if (k < s.length()) {
                        next += s.charAt(k);
                    }
                }
                if (pre.equals(next)) {
                    cnt++;
                }
                else {
                    if (1 < cnt) {
                        temp += cnt + pre;
                    }
                    else { 
                        temp += pre;
                    }
                    cnt = 1;
                    pre = next;
                }
            }
            if (1 < cnt) {
                temp += cnt + pre;
            }
            else {
                temp += pre;
            }
            answer = Math.min(answer, temp.length());
        }
        return answer;
    }
}
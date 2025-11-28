// 완주하지 못한 1명의 선수 return
import java.util.*;
class Solution {
    public static Map<String, Integer> map = new HashMap<>();
    public static String answer;
    public String solution(String[] participant, String[] completion) {
        
        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : completion) {
            map.put(s, map.getOrDefault(s, 0) - 1);
        }
        answer = test(participant);
        
        return answer;
    }
    public static String test(String[] participant) {
        for (String s : participant) {
            if (map.getOrDefault(s, 10) != 0) {
                return s;
            }
        }
        return "";
    }
}
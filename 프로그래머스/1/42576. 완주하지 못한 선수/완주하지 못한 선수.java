import java.util.*;
class Solution {
    private static Map<String, Integer> complete = new LinkedHashMap<>();
    public String solution(String[] participant, String[] completion) {
        for (String name : participant) {
            complete.put(name, complete.getOrDefault(name, 0) + 1);
        }
        
        for (String name : completion) {
            complete.put(name, complete.getOrDefault(name, 0) - 1);
        }
        
        return answer();
    }
    
    private String answer() {
        Set<Map.Entry<String, Integer>> es = complete.entrySet();
        for (Map.Entry<String, Integer> e : es) {
            if (e.getValue() == 1) {
                return e.getKey();
            }
        }
        return "";
    }
}
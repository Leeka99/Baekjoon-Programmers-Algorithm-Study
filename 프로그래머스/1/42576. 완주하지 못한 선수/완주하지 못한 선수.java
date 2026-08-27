import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }
        
        // for (Map.Entry<String, Integer> m : map.entrySet()) {
        //     System.out.println(m.getKey());
        //     System.out.println(m.getValue());
        // }
        
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (m.getValue() == 1) return m.getKey();
        }
        
        return answer;
    }
}
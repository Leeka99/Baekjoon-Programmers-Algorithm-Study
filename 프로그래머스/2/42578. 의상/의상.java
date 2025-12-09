import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String[] s : clothes) {
            map.put(s[1], map.getOrDefault(s[1], 0) + 1);
        }
        Collection<Integer> vals = map.values();
        int mul = 1;
        for (int n : vals) {
            mul *= (n + 1);
        }
        answer = mul - 1;
        return answer;
    }
}
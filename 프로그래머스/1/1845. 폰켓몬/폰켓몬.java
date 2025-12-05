import java.util.*;
class Solution {
    public static Map<Integer,Integer> map = new HashMap<>();
    public int solution(int[] nums) {
        for (int number : nums) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        int pickNumber = nums.length / 2;
        int number= map.size();
        return logic(number, pickNumber);
    }
    
    public static int logic(int number, int pickNumber) {
        if (map.size() < pickNumber) {
            return map.size();
        }
        return pickNumber;
    }
    // public static void test() {
    //     // Set<Map.Entry<Integer,Integer>> es = map.entrySet();
    //     // System.out.println(es);
    //     System.out.println(pickNumber);
    // }
}
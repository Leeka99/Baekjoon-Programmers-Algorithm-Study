import java.util.*;
// 연속 숫자 하나만 남기기. 순서는 유지
public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        
        for (int num : arr) {
            if (stack.isEmpty() || stack.peek() != num) {
                stack.push(num);
            }
        }
        
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
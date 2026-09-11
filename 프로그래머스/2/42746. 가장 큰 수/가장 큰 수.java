import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] nums = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(nums, (a,b) -> (b+a).compareTo(a+b));
        
        if (nums[0].equals("0")) return "0";
        
        for (String num : nums) {
            answer += num;
        }
        
        return answer;
    }
}
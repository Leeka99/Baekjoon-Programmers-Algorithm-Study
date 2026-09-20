import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        
        return dfs(numbers, target, 0, 0);
    }
    
    public int dfs(int[] numbers, int target, int ad, int index) {
        int cnt = 0;
        
        if (index == numbers.length) {
            if (ad == target) {
               cnt += 1;
            }
             return cnt;
        }
        
        cnt += dfs(numbers, target, ad + numbers[index], index + 1);
        cnt += dfs(numbers, target, ad - numbers[index], index + 1);
        
        return cnt;
    }
}
import java.util.*;
class Solution {
    public ArrayList solution(int[] array, int[][] commands) {
        ArrayList<Integer> result; 
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int[] command : commands) {
            result = new ArrayList<>();
            for (int i = command[0] - 1; i < command[1]; i++) {
                result.add(array[i]);
            }
            Collections.sort(result);
            
            answer.add(result.get(command[2] - 1));
        }
        return answer;
    }
}
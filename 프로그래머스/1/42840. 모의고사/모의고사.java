import java.util.*;
// 동점 => 오름차순 정렬, 누가 가장 많이 맞았나
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        int[][] students = {{1, 2, 3, 4, 5},{2, 1, 2, 3, 2, 4, 2, 5},{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int[] result = new int[3];
        
        
        for (int i = 0; i < 3; i++) {
            int j = 0;
            int tmp = 0;
            while(j < answers.length) {
                if (students[i][j % students[i].length] == answers[j]) {
                    tmp += 1;
                }
                j++;
            }
            result[i] = tmp;
        }
                
        int maxScore = 0;
        
        for (int i : result) {
            maxScore = Math.max(maxScore, i);
        }
        
        int idx = 0;
        for (int i = 0; i < result.length; i++) {
            if (maxScore == result[i]) {
                answer[idx] = i + 1;
                idx++;
            }
        }
        
        return Arrays.copyOf(answer, idx);
    }
}
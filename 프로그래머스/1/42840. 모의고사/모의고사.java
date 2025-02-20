import java.util.*;
class Solution {
    public static Queue<Integer> q1 = new LinkedList<>(Arrays.asList(1,2,3,4,5));
    public static Queue<Integer> q2 = new LinkedList<>(Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5));
    public static Queue<Integer> q3 = new LinkedList<>(Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));
    public static ArrayList<Integer> answer = new ArrayList<>();
    public ArrayList<Integer> solution(int[] answers) {
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        int max = 0;
        for (int i = 0; i < answers.length; i++) {
            
            int num1 = q1.poll();
            int num2 = q2.poll();
            int num3 = q3.poll();
            
            if (answers[i] == num1) {
                cnt1 += 1;
                max = Math.max(max, cnt1);
            }
            if (answers[i] == num2) {
                cnt2 += 1;
                max = Math.max(max, cnt2);
            }
            if (answers[i] == num3) {
                cnt3 += 1;
                max = Math.max(max, cnt3);
            }
            
            q1.add(num1);
            q2.add(num2);
            q3.add(num3);
        }
        
        if (max == cnt1) {
            answer.add(1);
        }
        if (max == cnt2) {
            answer.add(2);
        }
        if (max == cnt3) {
            answer.add(3);
        }
        
        return answer;
    }
}
import java.util.*;
class Solution {
    // 뒤 기능 먼저 개발할수도, 하지만 앞과 같이 배포
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < speeds.length; i++) {
            int num = ((100 - progresses[i]) % speeds[i]);
            int day = ((100 - progresses[i]) / speeds[i]);
            if (num == 0) queue.offer(day);
            else queue.offer(day+1);
        }
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            int count = 1;
            while(!queue.isEmpty() && curr >= queue.peek()) {
                count++;
                queue.poll();
            }
            answer.add(count);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
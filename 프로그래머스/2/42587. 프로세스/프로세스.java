
// 9시50분
// 규칙 따라 몇번째 실행?
//순서
// 1. 큐에서 하나 꺼내기
// 2. 우선순위 큰거 더 있으면 큐에 넣기
// 3. 꺼낸게 제일 높다면 꺼낸거 실행
// * 실행하면 버리기, 같다면 뒤에가 먼저
import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<Integer> original = new ArrayDeque<>();
        Queue<Integer> index = new ArrayDeque<>();
        Queue<Integer> target = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            original.offer(priorities[i]);
            index.offer(i);
        }
        Arrays.sort(priorities);
        for (int i = priorities.length - 1; i >= 0; i--) {
            target.offer(priorities[i]);
        }
        
        while(!original.isEmpty()) {
            int targetNum = target.peek();
            int originalNum = original.peek();
            int indexNum = index.peek();
            if (targetNum == originalNum){
                if (indexNum == location) break;
                else {
                    target.poll();
                    original.poll();
                    index.poll();
                    answer++;
                }
            }
            else {
                original.offer(original.poll());
                index.offer(index.poll());
            }
        }
        return answer;
    }
}
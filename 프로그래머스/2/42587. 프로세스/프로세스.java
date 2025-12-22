import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        List<Integer> r = new ArrayList<>();
        
        for (int index = 0; index < priorities.length; index++) {
            queue.add(priorities[index]);
            queue2.add(index);
            r.add(priorities[index]);
        }
        
        r.sort((a,b) -> Integer.compare(b, a));
                
        int rank = 0;
        while(!queue.isEmpty()) {
            int number = queue.poll();
            int index = queue2.poll();
            if (r.get(rank) != number) {
                queue.add(number);
                queue2.add(index);
                continue;
            }
            test(rank, number);
            if (index == location) {
                answer = rank + 1;
                break;
            }
            rank++;
        }
        
        return answer;
    }
    
    public void test(int rank, int num) {
        System.out.println("rank: " + rank + ", num: " + num);
    }
}
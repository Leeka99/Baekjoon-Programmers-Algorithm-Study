import java.util.*;
class Food {
    private int time;
    private int index;
    
    public Food(int time, int index) {
        this.time = time;
        this.index = index;
    }
    
    public int getTime() {
        return this.time;
    }
    
    public int getIndex() {
        return this.index;
    }
}
class Solution {
    public int solution(int[] food_times, long k) {
      int answer = 0;
        long summary = 0;
        for (int i = 0; i < food_times.length; i++) {
            summary += food_times[i];
        }
        if (summary <= k) return -1;
        
        PriorityQueue<Food> pq = new PriorityQueue<>(Comparator.comparingInt(Food::getTime));
        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new Food(food_times[i], i + 1));
        }
        
        summary = 0;
        long pre = 0;
        long length = food_times.length;
        
        while (summary + ((pq.peek().getTime() - pre) * length) <= k) {
            int now = pq.poll().getTime();
            summary += (now - pre) * length;
            length--;
            pre = now;
        }
        
        ArrayList<Food> result = new ArrayList<>(pq);
        result.sort(Comparator.comparingInt(Food::getIndex));
        
        int idx = (int)((k - summary) % length);
        
        return result.get(idx).getIndex();
    }
}
// 2명만 구출
// 50 50 70 80
import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int cnt = 0;
        Arrays.sort(people);
        for (int i = people.length - 1; i >= cnt; i--) {
            if (people[i] + people[cnt] <= limit) {
                answer += 1;
                cnt += 1;
            }
            else {
                answer += 1;
            }
        }
        return answer;
    }
}
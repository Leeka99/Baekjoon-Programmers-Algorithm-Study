// 기능 : k칸 앞으로 점프 , 현재까지 온 거리 * 2 위치로 순간이동
// 순간이동 - 건전지 안줄어듬. 점프하면 k만큼 줄어듬 . -> 순간이동이 효율적
// 구매자: 아이언 슈트 착용 후 n 만큼 거리 이동 , 건전지 아끼자 -> 점프 최소화
// 거리 n 주어짐 -> 건전지 사용량 리턴
// 1 2 4 8 16 32 64 ... 2n (x)
// 1 2 3 6  

import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        
        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
            }
            else {
                n -= 1;
                ans += 1;
            }
        }

        return ans;
    }
}
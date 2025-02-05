// (1,2)  (3,4) 느낌으로 진행
// 이긴 사람 다음 라운드 진출 -> 다시 1번부터 번호 배정
// 토너먼트 방식
// 부전승 없음
// a 와 b는 서로 만나기 전까지 항상 이긴다 가정
// 처음 라운드에서 a번 참가자 와 b번 참가자가 몇번째 라운드에서 만나는지 리턴
// 12 34 56 78 -> 3번째 만난다.
// n/2 + 1 - > 4
// n/2 -> 4
class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        while(a != b) {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            answer += 1;
        }
        return answer;
    }
}
// 끝말잇기 게임
// 한글자 안됨 , 단어 재등장 안됨, 마지막 문자로 시작
// 가장 먼저 탈락한 사람 번호 , 몇 번째 탈락하는지 구하기
// 탈락자 없으면 [0,0] 리턴
class Solution {
    public int[] solution(int n, String[] words) {
        
        if (words[0].length() == 1) {
            return new int[]{1,1};
        }
        
        for (int i = 1; i < words.length; i++) {
            if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                return new int[]{i % n + 1, i / n + 1};
            }
            
            if (words[i].length() == 1) {
                return new int[]{i % n + 1, i / n + 1};
            }
            
            for (int j = 0; j < i; j++) {
                if (words[i].equals(words[j])) {
                    return new int[]{i % n + 1, i / n + 1};
                }
            }
        }
        return new int[]{0,0};
    }
}
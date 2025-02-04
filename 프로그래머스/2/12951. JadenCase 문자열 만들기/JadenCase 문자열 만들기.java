class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] splits = s.split(" ", -1); // 연속된 공백도 유지하도록 -1 추가
        
        for (int i = 0; i < splits.length; i++) {
            if (!splits[i].isEmpty()) { // 빈 문자열 체크
                char firstChar = splits[i].charAt(0);
                
                // 첫 문자가 숫자인 경우 그대로 사용
                if (Character.isDigit(firstChar)) {
                    answer.append(firstChar);
                } else {
                    answer.append(Character.toUpperCase(firstChar)); // 첫 글자는 대문자로 변환
                }
                
                // 나머지 문자들은 소문자로 변환
                for (int j = 1; j < splits[i].length(); j++) {
                    answer.append(Character.toLowerCase(splits[i].charAt(j)));
                }
            }
            
            // 단어 사이의 공백 유지
            if (i < splits.length - 1) {
                answer.append(" ");
            }
        }
        return answer.toString();
    }
}

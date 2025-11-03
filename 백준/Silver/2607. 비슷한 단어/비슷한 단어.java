
// 조건 만족
// 같은 종류의 문자로 이루어짐
// 같은 문자는 같은 개수만큼 있음
// ex) DOG, GOD

// 첫 번째 단어와 비슷한 단어 모두 몇개?
// 대문자로 이루어짐
// 단어 개수는 100개 이하임. 각 단어의 길이는 10 이하

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String base = br.readLine();
        int answer = 0;

        int[] baseCount = new int[26];
        for (char c : base.toCharArray()) {
            baseCount[c - 'A']++;
        }

        for (int i = 1; i < n; i++) {
            String word = br.readLine();
            int[] wordCount = new int[26];
            for (char c : word.toCharArray()) {
                wordCount[c - 'A']++;
            }

            int diff = 0;
            for (int j = 0; j < 26; j++) {
                diff += Math.abs(baseCount[j] - wordCount[j]);
            }

            // 차이의 합이 2개 이하 && 길이 차이가 1 이하만 통과
            if (diff <= 2 && Math.abs(base.length() - word.length()) <= 1) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
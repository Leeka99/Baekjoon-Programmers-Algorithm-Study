import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String word = br.readLine();
            if (word.equals("end")) break;

            if (isAcceptable(word)) {
                System.out.println("<" + word + "> is acceptable.");
            } else {
                System.out.println("<" + word + "> is not acceptable.");
            }
        }
    }

    static boolean isAcceptable(String word) {
        // 모음이 하나 이상 있어야 함
        if (!containsVowel(word)) return false;

        // 같은 글자가 연속 두 번 오는 경우 (ee, oo 제외)
        for (int i = 0; i < word.length() - 1; i++) {
            char a = word.charAt(i);
            char b = word.charAt(i + 1);
            if (a == b && !(a == 'e' || a == 'o')) return false;
        }

        // 모음 3개 또는 자음 3개 연속 금지
        int vowelCount = 0;
        int consonantCount = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (isVowel(c)) {
                vowelCount++;
                consonantCount = 0;
            } else {
                consonantCount++;
                vowelCount = 0;
            }
            if (vowelCount == 3 || consonantCount == 3) return false;
        }

        return true; // 모든 조건 통과
    }

    // 모음 포함 여부
    static boolean containsVowel(String word) {
        for (char c : word.toCharArray()) {
            if (isVowel(c)) return true;
        }
        return false;
    }

    // 모음 판별
    static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
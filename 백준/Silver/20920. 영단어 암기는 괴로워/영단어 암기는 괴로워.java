import java.io.*;
import java.util.*;

//영어 단어장 만들기

/*
 * 규칙
 * 자주 나오는 단어 앞에 배치
 * 단어 길수록 앞에 배치
 * 알파벳 사전순으로 배치
 * m 이상의 단어만 외운다.
 */

public class Main {
    static int n; // 단어의 개수
    static int m; // 외울 단어의 길이 기준
    static List<String> arr = new ArrayList<>();
    static Map<String, Integer> name = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.length() < m) continue;
            arr.add(s);
            name.put(s, name.getOrDefault(s,0)+1);
        }

        List<String> answer = new ArrayList<>(name.keySet());

        Collections.sort(answer, (a,b) -> {
            int aCount = name.get(a);
            int bCount = name.get(b);

            if (aCount != bCount) return bCount - aCount;
            if (a.length() != b.length()) return b.length() - a.length();
            return a.compareTo(b);
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String s : answer) {
            bw.write(s);
            bw.newLine();
        }
        bw.flush();
    } 
}

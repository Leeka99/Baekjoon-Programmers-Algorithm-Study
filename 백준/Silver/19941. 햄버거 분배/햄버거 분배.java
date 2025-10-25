import java.util.*;
import java.io.*;

public class Main {
    static int n; // 총 길이
    static int k; // 먹을 수 있는 거리
    static char[] line;
    static int answer = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        line = br.readLine().toCharArray();

        for (int i = 0; i < n; i++) {
            if (line[i] == 'P') {
                for (int j = i - k; j <= i + k; j++) {
                    if (j < 0 || n <= j) continue;
                    if (line[j] == 'H') {
                        answer++;
                        line[j] = 'O';
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}

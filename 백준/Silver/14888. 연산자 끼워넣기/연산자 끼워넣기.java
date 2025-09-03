import java.io.*;
import java.util.*;

public class Main {
    public static int n, answerMax = Integer.MIN_VALUE, answerMin = Integer.MAX_VALUE;
    public static int[] numbers;
    public static int[] toolsNum = new int[4];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            toolsNum[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1,numbers[0]);

        System.out.println(answerMax);
        System.out.println(answerMin);

    }
    public static void dfs(int idx, int sum) {
        if (idx == n) {
            answerMax = Math.max(answerMax, sum);
            answerMin = Math.min(answerMin, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (toolsNum[i] > 0) {
                toolsNum[i]--;

                if (i == 0) dfs(idx + 1, sum + numbers[idx]);
                if (i == 1) dfs(idx + 1, sum - numbers[idx]);
                if (i == 2) dfs(idx + 1, sum * numbers[idx]);
                if (i == 3) dfs(idx + 1, sum / numbers[idx]);

                toolsNum[i]++;
            }
        }
    }
}

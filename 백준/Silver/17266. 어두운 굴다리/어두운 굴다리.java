import java.io.*;
import java.util.*;

// 최소한의 예산이 들 높이를 구하자
// 가로등 높이 h. 왼쪽 오른쪽 h만큼 주위를 비춤

public class Main {
    static int n; // 굴다리의 길이 1 <= n <= 100000
    static int m; // 가로등의 개수 1 <= m <= n 
    static int[] x; // 설치할 수 있는 가로등의 x 위치 0 <= x <= n
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        x = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Math.max(x[0], n - x[m - 1]);
        for (int i = 0; i < m -1; i++) {
            answer = Math.max(answer, (x[i + 1] - x[i] + 1) / 2);
        }

        System.out.println(answer);
    }
}

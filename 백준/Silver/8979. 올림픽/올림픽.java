import java.io.*;
import java.util.*;

public class Main {
    public static int n, k; // n : 국가의 수, k : 등수를 알고 싶은 국가
    public static int[][] arr;
    public static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr,(a,b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            if (a[2] != b[2]) return Integer.compare(a[2], b[2]);
            return Integer.compare(a[3], b[3]);
        });

        boolean b = false;
        for (int i = 0; i < n; i++) {
            if (arr[i][0] == k) {
                for (int j = 1; j < 4; j++) {
                    if (i == 0) {
                        System.out.println(1);
                        return;
                    }
                    for (int p = 1; p < 4; p++) {
                        if (arr[i - 1][p] == arr[i][p]) continue;

                        b = true;
                        break;
                    }
                    if (b) {
                        System.out.println(i+1);
                        return;
                    }
                    if (!b) {
                        System.out.println(i);
                        return;
                    }
                }
            }
        }
    }
}

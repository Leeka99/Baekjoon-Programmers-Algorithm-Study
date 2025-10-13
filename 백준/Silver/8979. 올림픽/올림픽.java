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
            if (a[1] != b[1]) return Integer.compare(b[1], a[1]);
            if (a[2] != b[2]) return Integer.compare(b[2], a[2]);
            return Integer.compare(b[3], a[3]);
        });

        int rank = 1;
        int targetRank = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                if (arr[i][1] == arr[i - 1][1] &&
                    arr[i][2] == arr[i - 1][2] &&
                    arr[i][3] == arr[i - 1][3]) {
                } 
                
                else rank = i + 1;
            }

            if (arr[i][0] == k) {
                targetRank = rank;
                break;
            }
        }

        System.out.println(targetRank);
    }
}
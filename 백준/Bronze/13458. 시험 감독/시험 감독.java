import java.io.*;
import java.util.*;

public class Main {
    public static int n, b, c;
    public static long answer;
    public static int[] classroom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        classroom = new int[n];
        answer = n;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {

            classroom[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            int number = classroom[i] - b;
            if (number <= 0) continue;

            answer += (number / c);
            if (number % c != 0) answer += 1;
        }

        System.out.println(answer);
    }
}

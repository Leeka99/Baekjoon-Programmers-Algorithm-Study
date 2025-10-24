import java.io.*;
import java.util.StringTokenizer;

// x일동안 가장 많이 들어온 방문자 수와 그 기간들을 알고 싶다.
// 특정 구간에서 최대값 찾기

// 2중 for문 x
// 슬라이딩 윈도우 사용

public class Main {
    static int n; // 블로그 시작하고 지난일수
    static int x; // 기준이 되는 일수
    static int[] numbers;
    static int answer = 0;
    static int sum = 0;
    static int same = 1;
    static int s = 0;
    static int e;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        numbers = new int[n];
        e = x-1;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= e; i++) {
            int numer = numbers[i];
            answer += numer;
            sum += numer;
        }

        if (n == x) {
            if (answer == 0) System.out.println("SAD");
            else {
                System.out.println(answer);
                System.out.println(1);
            }
            return;
        }
            
        for (int i = x; i < n; i++) {
            sum += numbers[i] - numbers[i - x];
            if (sum == answer) same++;
            if (answer < sum) {
                same = 1;
                answer = sum;
            }
        }

        if (answer == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(answer);
        System.out.println(same);
    }
}

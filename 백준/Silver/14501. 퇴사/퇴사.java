import java.util.*;
import java.io.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    public static int n, answer;
    public static Point[] days;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        days = new Point[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            days[i] = new Point(a, b);
        }

        answer = 0;
        dfs(0,0);

        System.out.println(answer);

    }

    public static void dfs(int day, int sum) {

        if (day >= n) {
            answer = Math.max(answer, sum);
            return;
        }

        dfs(day + 1, sum);

        int currDay = days[day].x;
        int currPay = days[day].y;
            
        if (day + currDay <= n) {
            dfs(day + currDay, sum + currPay);
        }
    }
}

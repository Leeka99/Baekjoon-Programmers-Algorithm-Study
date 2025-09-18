import java.io.*;
import java.util.*;;

public class Main {
    public static int n, k;
    public static int[] belt, robot;
    public static int count = 0;
    public static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        belt = new int[n*2 + 1];
        robot = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n*2; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        while (count < k) {
            moveBelt();
            moveRobot();
            putRobot();
            count = count();
            answer++;
        }
        System.out.println(answer);
    }

    // 밸트 회전 + 로봇 위치 이동 함수
    public static void moveBelt() {
        int temp = belt[2*n];
        for (int i = 2*n; i>=2; i--) {
            belt[i] = belt[i - 1];
        } 
        belt[1] = temp;

        for (int i = n; i >= 2; i--) {
            robot[i] = robot[i - 1];
        }
        robot[1] = 0;

        if(robot[n] == 1) robot[n] = 0;
    }

    // 로봇 이동 함수
    public static void moveRobot() {
        for (int i = n; i >= 2; i--) {
            if (robot[i - 1] == 1 && belt[i] > 0 && robot[i] == 0) {
                robot[i] = 1;
                belt[i]--;
                robot[i - 1] = 0;
            }
        }
        if (robot[n] == 1) robot[n] = 0;
    }

    // 로봇 올리는 함수
    public static void putRobot() {
        if (belt[1] != 0) {
            robot[1] = 1;
            belt[1]--;
        }
    }

    // 내구도 0인 개수 세기
    public static int count() {
        int cnt = 0;
        for (int i = 1; i <= 2*n; i++) {
            if (belt[i] == 0) cnt++;
        }
        return cnt;
    }
}

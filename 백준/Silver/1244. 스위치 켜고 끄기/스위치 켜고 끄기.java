import java.util.*;
import java.io.*;

public class Main {
    static int swithNum; // swithNum <= 100
    static int[] status; // 스위치들 상태. 0 : 꺼짐
    static int studentsNum; // 학생 수 <= 100
    static int[][] students;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        swithNum = Integer.parseInt(br.readLine());
        status = new int[swithNum + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= swithNum; i++) {
            status[i] = Integer.parseInt(st.nextToken());
        }
        studentsNum = Integer.parseInt(br.readLine());
        students = new int[studentsNum][2];

        for (int i = 0; i < studentsNum; i++) {
            st = new StringTokenizer(br.readLine());
            students[i][0] = Integer.parseInt(st.nextToken());
            students[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        start();
        answer();
    }

    static void start() {
        // 학생 1명씩 실행
        for (int i = 0; i < studentsNum; i++) {
            int sNum = students[i][1];
            if (students[i][0] == 1) boy(sNum);  // 남자 경우 로직 실행
            if (students[i][0] == 2) girl(sNum); // 여자 경우 로직 실행
        }
    }

    static void boy(int sNum) {
        for (int i = sNum; i <= swithNum; i += sNum) {
            status[i] = Math.abs(status[i] - 1);
        }
    }

    static void girl(int sNum) {
        int left = sNum;
        int right = sNum;

        while (left - 1 >= 1 && right + 1 <= swithNum && status[left - 1] == status[right + 1]) {
            left--;
            right++;
        }

        for (int i = left; i <= right; i++) {
            status[i] = Math.abs(status[i] - 1);
        }
    }

    static void answer() {
        for (int i = 1; i <= swithNum; i++) {
            System.out.print(status[i] + " ");

            if(i % 20 == 0) {
                System.out.println();
            }
        }
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static char[][] arr = new char[4][8];
    public static int k;
    public static int answer = 0;
    public static int[] dir;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        k = Integer.parseInt(br.readLine());

        // 계산 로직
        for (int i = 0; i < k; i++) {
            dir = new int[4];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int topni = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            dir[topni] = d;
            checkLeft(topni);
            checkRight(topni);
            move();
        }

        // 점수 계산
        for (int j = 0; j < 4; j++) {
            if (arr[j][0] == '1' && j == 0) answer += 1;
            if (arr[j][0] == '1' && j == 1) answer += 2;
            if (arr[j][0] == '1' && j == 2) answer += 4;
            if (arr[j][0] == '1' && j == 3) answer += 8;
                
        }

        // 결과
        System.out.println(answer);
    }

    // 오른쪽 회전 로직
    public static void moveRight(int topni) {
        char[] copy = arr[topni].clone();
        copy[0] = arr[topni][7];
        copy[1] = arr[topni][0];
        copy[2] = arr[topni][1];
        copy[3] = arr[topni][2];
        copy[4] = arr[topni][3];
        copy[5] = arr[topni][4];
        copy[6] = arr[topni][5];
        copy[7] = arr[topni][6];
        
        arr[topni] = copy;
    }

    // 왼쪽 회전 로직
    public static void moveLeft(int topni) {
        char[] copy = arr[topni].clone();
        copy[0] = arr[topni][1];
        copy[1] = arr[topni][2];
        copy[2] = arr[topni][3];
        copy[3] = arr[topni][4];
        copy[4] = arr[topni][5];
        copy[5] = arr[topni][6];
        copy[6] = arr[topni][7];
        copy[7] = arr[topni][0];

        arr[topni] = copy;
    }

    // 왼쪽 톱니 체크
    public static void checkLeft(int topni) {
        for (int i = topni - 1; i >= 0; i--) {
            if (arr[i + 1][6] != arr[i][2]) dir[i] = -dir[i + 1];
            
            else break;
        }
    }

    // 오른쪽 톱니 체크
    public static void checkRight(int topni) {
        for (int i = topni; i < 3; i++) {
            if (arr[i][2] != arr[i + 1][6]) dir[i + 1] = -dir[i];
            
            else break;
        }
    }

    // 회전
    public static void move() {
        for (int i = 0; i < 4; i++) {
            if (dir[i] == 1) moveRight(i);
            if (dir[i] == -1) moveLeft(i);
        }
    }
}

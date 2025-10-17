import java.io.*;
import java.util.*;

/**
조건
머리 : 크기 1칸. 심장 바로 위
팔 : 심장에서 각각 오른쪽 왼쪽. 길이 1 이상. 너비는 1
다리 : 심장에서 왼쪽, 오른쪽 아래. 길이 1 이상. 너비는 1 

* : 쿠키의 신체부분. 
_ : 신체가 아닌 곳
 */

/**
출력
- 심장이 위치한 행의 번호 x, 열의 번호 y
- 왼쪽팔, 오른쪽팔, 왼쪽 다리, 오른쪽 다리
 */
// 핵심 풀이 : 우선 심장을 찾자. 4방향 모두 *이 존재하면 심장이다?
public class Main {
    static int n;
    static char[][] arr;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int heartX;
    static int heartY;
    static int backX;
    static int backY;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        findHeart();
        findBody();
    }

    static void findBody() {
        findArms();
        findBack();
        findLegs();
    }

    // 팔 길이 구하기
    static void findArms() {
        leftArm();
        rightArm();
    }

    static void leftArm() {
        int cx = heartX;
        int cy = heartY;
        int cnt = 0;
        while (true) {
            cy--;
            if (canGo(cx, cy) && arr[cx][cy] == '*') cnt++;
            else {
                System.out.print(cnt + " ");
                break;
            }
        }
    }

    static void rightArm() {
        int cx = heartX;
        int cy = heartY;
        int cnt = 0;
        while(true) {
            cy++;
            if (canGo(cx, cy) && arr[cx][cy] == '*') cnt++;
            else {
                System.out.print(cnt + " ");
                break;
            }
        }
    }

    // 허리 길이 구하기
    static void findBack() {
        int cx = heartX;
        int cy = heartY;
        int cnt = 0;
        while (true) {
            cx++;
            if (canGo(cx, cy) && arr[cx][cy] == '*') cnt++;
            else {
                System.out.print(cnt + " ");
                backX = heartX + cnt;
                backY = heartY;
                break;
            }
        }
    }

    // 다리 길이 구하기
    static void findLegs() {
        leftLeg();
        rightLeg();
    }

    static void leftLeg() {
        int cx = backX;
        int cy = backY-1;
        int cnt = 0;
        while (true) {
            cx++;
            if (canGo(cx, cy) && arr[cx][cy] == '*') cnt++;
            else {
                System.out.print(cnt + " ");
                break;
            }
        }
    }

    static void rightLeg() {
        int cx = backX;
        int cy = backY+1;
        int cnt = 0;
        while (true) {
            cx++;
            if (canGo(cx, cy) && arr[cx][cy] == '*') cnt++;
            else {
                System.out.print(cnt + " ");
                break;
            }
        }
    }

    // 심장 찾기
    static void findHeart() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                if (arr[i][j] == '*') {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (canGo(nx, ny) && arr[nx][ny] == '*') cnt++;
                    }
                }
                
                if (cnt == 4) {
                    heartX = i;
                    heartY = j;
                    System.out.println((heartX + 1) +  " " + (heartY + 1));
                    return;
                }
                
            }
        }
    }

    static boolean canGo(int nx, int ny) {
        return 0 <= nx && 0 <= ny && nx < n && ny < n;
    }
}

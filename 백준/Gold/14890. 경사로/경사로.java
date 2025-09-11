import java.util.*;
import java.io.*;

public class Main {
    public static int n, l;
    public static int[][] map;
    public static int answer = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가로로 쭉 확인
        for (int i = 0; i < n; i++) {
            if (checkRow(i)) answer++;
        }

        // 세로로 쭉 확인
        for (int i = 0; i < n; i++) {
            if (checkCol(i)) answer++;
        }
        System.out.println(answer);
    }

    public static boolean checkRow(int row) {

        // 경사로 설치 여부 기록
        boolean[] used = new boolean[n];

        for (int j = 0; j < n - 1; j++) {
            int curr = map[row][j];
            int next = map[row][j + 1];

            // 높이 같으면 진행
            if (curr == next) continue; 

            // 차이 2 이상 -> 불가
            if (Math.abs(curr - next) > 1) return false; 

            // 올라가는 경사로
            if (curr + 1 == next) { 
                for (int k = 0; k < l; k++) {
                    int pos = j - k;
                    if (pos < 0 || map[row][pos] != curr || used[pos]) return false;
                    used[pos] = true;
                }

            // 내려가는 경사로
            } else if (curr - 1 == next) { 
                for (int k = 1; k <= l; k++) {
                    int pos = j + k;
                    if (pos >= n || map[row][pos] != next || used[pos]) return false;
                    used[pos] = true;
                }
            }
        }
        // 경사로 가능
        return true;
    }

    public static boolean checkCol(int col) {
        boolean[] used = new boolean[n];
        
        for (int j = 0; j < n - 1; j++) {
            int curr = map[j][col];
            int next = map[j + 1][col];

            // 단차 같다면 계속
            if (curr == next) continue;

            // 단차 1 초과하면 종료
            if (Math.abs(curr - next) > 1) return false;

            // 올라가는 경사로
            if (curr + 1 == next) {
                for (int k = 0; k < l; k++) {
                    int pos = j - k;
                    if (pos < 0 || map[pos][col] != curr || used[pos]) return false;
                    used[pos] = true;
                }
            // 내려가는 경사로
            } else if (curr - 1 == next) {
                for (int k = 1; k <= l; k++) {
                    int pos = j + k;
                    if (pos >= n || map[pos][col] != next || used[pos]) return false;
                    used[pos] = true;
                }
            }
        } 
        // 경사로 가능
        return true;
    }
}

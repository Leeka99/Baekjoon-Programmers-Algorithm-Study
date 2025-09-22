import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static int[][] like;
    static int[] order;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Seat {
        int x, y, likeCnt, blankCnt;
        Seat(int x, int y, int likeCnt, int blankCnt) {
            this.x = x;
            this.y = y;
            this.likeCnt = likeCnt;
            this.blankCnt = blankCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        like = new int[n*n + 1][4];
        order = new int[n*n];

        for (int i = 0; i < n*n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            order[i] = student;
            for (int j = 0; j < 4; j++) {
                like[student][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 학생들 배치
        for (int student : order) {
            place(student);
        }

        // 만족도 계산
        System.out.println(getSatisfaction());
    }

    // 특정 학생 자리 배치
    static void place(int student) {
        List<Seat> candidates = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) continue; // 이미 차있음
                int likeCnt = 0, blankCnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if (!canGo(nx, ny)) continue;
                    if (map[nx][ny] == 0) blankCnt++;
                    else if (isLike(student, map[nx][ny])) likeCnt++;
                }
                candidates.add(new Seat(i, j, likeCnt, blankCnt));
            }
        }

        // 자바의 sort는 음수가 나오면 a가 앞으로, 양수가 나오면 b가 앞으로 배치됨
        candidates.sort((a, b) -> {
            if (a.likeCnt != b.likeCnt) return b.likeCnt - a.likeCnt; // 1순위
            if (a.blankCnt != b.blankCnt) return b.blankCnt - a.blankCnt; // 2순위
            if (a.x != b.x) return a.x - b.x; // 3순위
            return a.y - b.y; // 4순위
        });

        Seat best = candidates.get(0);
        map[best.x][best.y] = student;
    }

    // 좋아하는 학생인지 확인
    static boolean isLike(int student, int other) {
        for (int i = 0; i < 4; i++) {
            if (like[student][i] == other) return true;
        }
        return false;
    }

    // 만족도 계산
    static int getSatisfaction() {
        int sum = 0;
        int[] score = {0, 1, 10, 100, 1000};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int student = map[i][j];
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if (!canGo(nx, ny)) continue;
                    if (isLike(student, map[nx][ny])) cnt++;
                }
                sum += score[cnt];
            }
        }
        return sum;
    }

    // 범위 확인
    static boolean canGo(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}

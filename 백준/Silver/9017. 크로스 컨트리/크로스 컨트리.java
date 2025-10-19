/**
 * 크로스 컨트리 
 * 개인성적 매기고 -> 팀의 점수를 계산 (상위 4명 점수 합산)
 * 한팀 : 6명.
 * 가장 낮은 점수 팀 "우승"
 * 6명 참가하지 못한 팀은 점수 계산에서 제외
 * 동점일 경우 다섯번째 주자가 가장 빨리 들어온 팀이 우승
 * 정답 출력 : 우승팀을 출력하라 
 */

 /*
  * 예외 발생할만한 부분
  player 인덱스 번호를 teamNumbers가 사용할때
  
  */

import java.io.*;
import java.util.*;

public class Main {
    static int t; // 테스트 케이스 수
    static int n; // 6 <= n <= 1000
    static int[][] teamNumbers; // 기록, 점수

// 몇 명 출전, 점수 누적, 몇명까지 합산
    static int[][] player;

    static int minScore;
    static int winner;

    static void input(BufferedReader br) throws IOException {
        n = Integer.parseInt(br.readLine());
        teamNumbers = new int[n][2];
        player = new int[201][3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            teamNumbers[i][0] = Integer.parseInt(st.nextToken());
            player[teamNumbers[i][0]][0]++;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            input(br);
            calcWinner();
            // 동점자 있는지 계산
            if (findEqual()) {
                // 5순위도 더하기
                finalWinner();
            }
            System.out.println(winner);
        }
    }

    // 5순위까지 합한 최종 우승자
    static void finalWinner() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int number = teamNumbers[i][0];
            if (minScore == player[number][1] && teamNumbers[i][1] != 0 && min > teamNumbers[i][1]) {
                min = teamNumbers[i][1];
                winner = teamNumbers[i][0];
            }
        }
    }

    // 동점자 있는지 계산 && 
    static boolean findEqual() {
        minScore = Integer.MAX_VALUE;
        winner = 0;
        boolean b = false;
        for (int i = 1; i < player.length; i++) {
            if (player[i][0] == 0) break;
            if (player[i][1] == 0) continue;
            if (player[i][0] == 6 && player[i][1] != 0 && player[i][1] < minScore) {
                minScore = player[i][1];
                winner = i;
                b = false;
            }
            if (minScore == player[i][1]) b = true;
        }
        return b;
    }

    // 상위 4명만 계산
    static void calcWinner() {
        int score = 1;
        for (int i = 0; i < n; i++) {
            int number = teamNumbers[i][0]; // 팀번호
            if (player[number][0] != 6) continue;
            if (player[number][2] < 4) player[number][1] += score;

            if (player[number][2] == 4) {
                teamNumbers[i][1] = score;
            }
            player[number][2]++;
            score++;
        }
    }
}

// 노래마다 랭킹 리스트 있음 -> 매번 게임마다 얻는 점수 비오름차순
// 랭킹 리스트가 꽉 차있을 때, 새 점수가 이전 점수보다 더 좋을 때만 점수가 바뀐다.
// 정답 : 태수의 새로운 점수가 랭킹 리스트에서 몇등인가? 랭킹 리스트 못 올라간다면 -1 출력

import java.io.*;
import java.util.*;

public class Main {
    static int n; // 리스트에 있는 점수 n개. 0 <= n <= p
    static int tesu; // 태수의 새로운 점수
    static int p; // 랭킹 리스트에 올라 갈 수 있는 점수의 개수. 10 <= p <= 50

    static List<Integer> scores = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        tesu = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        // 랭킹리스트에 아무것도 없다면
        if (n == 0) {
            System.out.println(1);
            return;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            scores.add(Integer.parseInt(st.nextToken()));
        }
        System.out.println(Compare());
    }

    static int Compare(){
        // 랭킹 리스트 가득참 && 배열 마지막 값 태수보다 크다면 -1 
        if (scores.size() == p && tesu <= scores.get(scores.size() - 1)) {
            return -1;
        }
        
        // 태수가 더 크거나 동점
        for (int i = 0; i < scores.size(); i++) {  
            if (scores.get(i) <= tesu) {
                return i + 1;
            }
        }

        // 랭킹 리스트 자리 있고 태수 점수 낮을때
        return scores.size() + 1;
    }
}

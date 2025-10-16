import java.io.*;
import java.util.*;

// y : 2 , f : 3 , o : 4 -> 인원수 부족하면 게임 시작 불가
// 같은 사람하고 다시 안함
public class Main {
    static int n; // 임스와 같이 플레이하기를 신청한 횟수
    static String gameName; // 플레이할 게임의 종류
    static int answer = 0;
    static int y = 1;
    static int f = 2;
    static int o = 3;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        gameName = st.nextToken();
        
        Set<String> people = new HashSet<>();
        for (int i = 0; i < n; i++) {
            people.add(br.readLine());
        }

        int poepleCount = people.size();


        if (gameName.equals("Y")) answer = poepleCount / y;
        if (gameName.equals("F")) answer = poepleCount / f;
        if (gameName.equals("O")) answer = poepleCount / o;

        System.out.println(answer);
    }
}

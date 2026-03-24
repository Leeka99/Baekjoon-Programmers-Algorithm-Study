import java.util.*;

public class Main {
    private static int answer = Integer.MAX_VALUE;
    private static int n, c;
    private static ArrayList<int[]> house = new ArrayList<>();
    private static ArrayList<int[]> store = new ArrayList<>();
    private static boolean[] open;

    private static void dfs(int start, int depth) {

        if (depth == c) {
            int result = 0;
            for (int h = 0; h < house.size(); h++) {
                int hx = house.get(h)[0];
                int hy = house.get(h)[1];
                int sum = Integer.MAX_VALUE;
                for (int s = 0; s < store.size(); s++) {
                    if (open[s]) {
                        int sx = store.get(s)[0];
                        int sy = store.get(s)[1];
                        int num = Math.abs(hx - sx) + Math.abs(hy - sy);
                        sum = Math.min(num, sum);
                    }

                }
                result += sum;
            }
            answer = Math.min(answer, result);
        }

        // 백트래킹: 전체 치킨집 개수 중 c개 뽑기
        for (int i = start; i < store.size(); i++) {
            open[i] = true;
            dfs(i + 1, depth + 1);
            open[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n 입력받기
        n = sc.nextInt();
        // c 입력받기
        c = sc.nextInt();

        // 위치 저장
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int num = sc.nextInt();
                // 집 위치 저장
                if (num == 1)
                    house.add(new int[] { i, j });
                // 치킨 집 위치 저장
                if (num == 2)
                    store.add(new int[] { i, j });
            }
        }
        sc.close();

        open = new boolean[store.size()];

        // 집 위치를 기준으로 모든 치킨 집 탐색
        dfs(0, 0);
        System.out.println(answer);
    }
}
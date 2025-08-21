import java.util.*;
// n 정점의 개수, m 간선의 개수, v 탐색 시작할 정점의 번호

public class Main {

    public static boolean[] visited;
    public static int[][] arr;
    public static int n;
    public static int m;
    public static int v;

    public static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();

        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            // 양방향 간선 연결
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        dfs(v);
        System.out.println();
        visited = new boolean[n + 1];
        bfs(v);

        sc.close();
    }

    public static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int i = 0; i <= n; i++) {
            if (arr[v][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            v = queue.poll();
            System.out.print(v + " ");

            for (int i = 1; i <= n; i++) {
                if (arr[v][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
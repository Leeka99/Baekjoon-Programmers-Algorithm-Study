import java.util.*;

public class Main {
    // 도시개수, 도로개수,거리정보,시작위치
    private static int n, m, k, x;
    private static ArrayList<Integer>[] graph;
    private static int[] distance;

    private static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(x);
        distance[x] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph[curr]) {
                if (distance[next] == -1) {
                    distance[next] = distance[curr] + 1;
                    queue.offer(next);
                }
            }
        }
    }

    private static void answer() {
        boolean found = false;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == k) {
                System.out.println(i);
                found = true;
            }
        }
        if (!found)
            System.out.println(-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();
        graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
        }
        sc.close();

        distance = new int[n + 1];
        Arrays.fill(distance, -1);

        bfs();
        answer();

    }
}
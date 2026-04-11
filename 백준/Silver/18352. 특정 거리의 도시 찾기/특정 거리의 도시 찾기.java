import java.util.*;

public class Main {
    private static ArrayList<Integer>[] map;
    private static boolean[] visited;
    private static int n, m, k, x;
    private static ArrayList<Integer> answer = new ArrayList<>();

    private static void test() {
        for (int i = 1; i < map.length; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < map[i].size(); j++) {
                System.out.print(map[i].get(j) + ", ");
            }
            System.out.println();
        }
    }

    private static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { x, 0 });

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (visited[curr[0]] == true)
                continue;
            for (int i = 0; i < map[curr[0]].size(); i++) {
                queue.offer(new int[] { map[curr[0]].get(i), curr[1] + 1 });
            }
            visited[curr[0]] = true;
            if (curr[1] == k)
                answer.add(curr[0]);
            if (curr[1] > k)
                break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();

        map = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            map[num1].add(num2);
        }
        sc.close();
        bfs();
        Collections.sort(answer);
        if (answer.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < answer.size(); i++) {
                System.out.println(answer.get(i));
            }
        }
    }
}
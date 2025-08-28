import java.util.Scanner;

public class Main {
    public static int com;
    public static int line;
    public static int[][] arr;
    public static boolean[] visited;
    public static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        com = Integer.parseInt(sc.nextLine());
        line = Integer.parseInt(sc.nextLine());

        arr = new int[com + 1][com + 1];
        visited = new boolean[com + 1];

        for (int i = 0; i < line; i++) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");

            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        dfs(1);
        System.out.println(answer);
    }

    public static void dfs(int n) {
        visited[n] = true;

        for (int i = 1; i <= com; i++) {
            if (arr[n][i] == 1 && !visited[i]) {
                dfs(i);
                answer += 1;
            }
        }
    }
}

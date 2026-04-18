import java.util.*;

public class Main {

    private static int n;
    private static int maxNum = Integer.MIN_VALUE, minNum = Integer.MAX_VALUE;
    private static int[] numArr;
    // +, -, *, /
    private static int[] operatorArr = new int[4];

    private static void dfs(int result, int cnt) {

        if (cnt == n) {
            maxNum = Math.max(result, maxNum);
            minNum = Math.min(result, minNum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operatorArr[i] != 0) {
                operatorArr[i]--;
                if (i == 0)
                    dfs(result + numArr[cnt], cnt + 1);
                if (i == 1)
                    dfs(result - numArr[cnt], cnt + 1);
                if (i == 2)
                    dfs(result * numArr[cnt], cnt + 1);
                if (i == 3)
                    dfs(result / numArr[cnt], cnt + 1);
                operatorArr[i]++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        numArr = new int[n];

        for (int i = 0; i < n; i++) {
            numArr[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            operatorArr[i] = sc.nextInt();
        }

        sc.close();

        dfs(numArr[0], 1);
        System.out.println(maxNum);
        System.out.println(minNum);
    }
}
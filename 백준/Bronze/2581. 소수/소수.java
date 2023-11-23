import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int m = input.nextInt();
        int n = input.nextInt();

        int sum = 0;
        int min = n;

        x : for (int i = m; i <= n; i++) {
            if (i == 1) {
                continue;
            }
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    continue x;
                }
            }
            sum += i;
            if (min > i) {
                min = i;
            }
        }
        if (sum == 0 ) {
            System.out.println(-1);
            return;
        }
        System.out.println(sum + "\n" + min);
    }
}

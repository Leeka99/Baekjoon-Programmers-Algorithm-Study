import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        if (n % 2 == 0) System.out.println("CY");
        if (n % 2 != 0) System.out.println("SK");
    }
}

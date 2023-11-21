import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        int numbers;
        int count = 0;

        for (int i = 0; i < number; i++) {
            numbers = input.nextInt();
            for (int j = 2; j <= numbers; j++) {
                if (j == numbers){
                    count++;
                }
                if (numbers % j == 0){
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
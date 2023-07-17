import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	int T =sc.nextInt();
	int result=0;
	
	for(int i=0; i<T; i++) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		result = a+b;
		System.out.println(result);
	}
	sc.close();
	
	}

}

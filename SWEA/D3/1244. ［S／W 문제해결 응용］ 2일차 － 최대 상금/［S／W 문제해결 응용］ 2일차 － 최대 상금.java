import java.util.*;
import java.io.*;

public class Solution {
	public static int testValue;
	public static int n;
	public static String numbers;
	public static char[] charNumbers;
	public static String answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		testValue = Integer.parseInt(br.readLine());
		
		for (int index = 1; index <= testValue; index++) {
			st = new StringTokenizer(br.readLine());
			numbers = st.nextToken();
			charNumbers = numbers.toCharArray();
			n = Integer.parseInt(st.nextToken());
			
			answer = "";
			logic(0,0);
			System.out.println("#" + index + " " + answer);
		}
	}
	
	public static void logic(int depth, int count) {
		numbers = new String(charNumbers);
		if (count == n) {
			if (numbers.compareTo(answer) > 0) {
				answer = numbers;
			}
			return;
		}
		
		for (int i = depth; i < numbers.length(); i++) {
			for (int j = i + 1; j < numbers.length(); j++) {
				temp(i, j);
				logic(i, count + 1);
				temp(i, j);
			}
		}
	}
	
	public static void temp(int i, int j) {
		char temp = charNumbers[i];
		charNumbers[i] = charNumbers[j];
		charNumbers[j] = temp;
	}
}

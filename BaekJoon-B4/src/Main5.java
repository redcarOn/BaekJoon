//No.4299
import java.io.IOException;
import java.util.Scanner;

public class Main5 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int sum = sc.nextInt();
		int dif = sc.nextInt();
		int win = 0;
		int lose = 0;
		sc.close();
		if ((sum + dif) % 2 != 0 || (sum - dif) % 2 != 0 || (sum - dif) < 0) {
			System.out.println(-1);
			return;
		}
		win = (sum + dif) / 2;
		lose = (sum - dif) / 2;
		System.out.println(win + " " + lose);
		
	}
}

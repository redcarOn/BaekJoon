
//No.2884
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int H, M, count;
		H = sc.nextInt();
		M = sc.nextInt();
		count = H * 60 + M - 45;

		if (count < 0) {
			count = 1440 + count;
		}
		H = count / 60;
		M = count % 60;

		System.out.println(H + " " + M);
		sc.close();
	}
}

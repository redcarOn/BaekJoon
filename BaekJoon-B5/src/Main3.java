// No.14681
import java.io.IOException;
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int x, y, result;
		x = sc.nextInt();
		y = sc.nextInt();
		if (x > 0 && y > 0)
			result = 1;
		else if (x < 0 && y > 0)
			result = 2;
		else if (x < 0 && y < 0)
			result = 3;
		else
			result = 4;
		System.out.println(result);
		sc.close();
	}
}
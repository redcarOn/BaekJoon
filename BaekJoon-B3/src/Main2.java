
//No.2588
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A, B, x, y, z, result;
		A = sc.nextInt();
		B = sc.nextInt();
		x = A * (B % 10);
		y = A * (B % 100 - B % 10) / 10;
		z = A * (B - B % 100) / 100;
		result = x + y * 10 + z * 100;
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		System.out.println(result);
		sc.close();
	}
}
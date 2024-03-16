
//No.1193
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main08 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		check(X);

	}

	public static void check(int n) {
		int i = 0;
		int count = 0;

		while (true) {
			if (n <= i) {
				break;
			} else {
				n -= i++;
				count++;
			}
		}
		int sum = count + 1;
		int mol, den;
		if (count % 2 == 1) {
			den = n;
			mol = sum - den;

		} else {
			mol = n;
			den = sum - mol;
		}
		System.out.println(mol + "/" + den);
	}
}
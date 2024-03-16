
//No.2839
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main01_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;

		if (N == 4 || N == 7) {
			count = -1;
		} else if (N % 5 == 0) {
			count = N / 5;
		} else if (N % 5 == 1 || N % 5 == 3) {
			count = N / 5 + 1;
		} else if (N % 5 == 2 || N % 5 == 4) {
			count = N / 5 + 2;
		}
		System.out.println(count);
	}
}
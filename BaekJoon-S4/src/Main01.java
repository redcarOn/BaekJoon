
//No.2839
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main01 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = Sugar(N);
		System.out.println(count);
	}

	private static int Sugar(int N) {
		int count = 0;

		while (N != 0) {
			if (N / 3 == 0) {
				count = -1;
				break;
			} else if (N % 3 == 0 && N % 5 == 0) {
				count += 3;
				N -= 15;
			} else if (N % 3 != 0 && N / 5 != 0) {
				count++;
				N -= 5;
			} else if (N % 3 == 0 && N / 5 != 0) {
				count++;
				N -= 3;
			} else {
				count++;
				N -= 3;
			}

		}
		return count;
	}
}
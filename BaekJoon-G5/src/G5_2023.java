
// No.2023(신기한 소수) - 45
// 백트래킹 - 소수판정 - 에라토스테네스의 체 사용X
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_2023 {
	static int N;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		amazingPrime(0, 0);

		System.out.println(sb);
	}

	static void amazingPrime(int num, int depth) {
		if (depth == N) {
			sb.append(num).append('\n');
			return;
		}

		for (int i = 1; i < 10; i++) {
			int tmp = num * 10 + i;

			if (isPrime(tmp)) {
				amazingPrime(tmp, depth + 1);
			}
		}
	}

	static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
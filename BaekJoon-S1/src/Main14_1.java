
//No.6588(골드바흐의 추축) - 소수 판정(시간 단축)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main14_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		boolean[] arr = new boolean[1000001];

		for (int i = 2; i <= Math.sqrt(arr.length); i++) {
			if (arr[i]) {
				continue;
			}
			for (int j = i * i; j < arr.length; j += i) {
				arr[j] = true;
			}
		}

		while (true) {
			boolean flag = false;
			int n = Integer.parseInt(br.readLine());

			if (n == 0) {
				break;
			}

			for (int i = 3; i <= n / 2; i += 2) {
				if (arr[i]) {
					continue;
				}
				if (!arr[n - i]) {
					sb.append(n + " = " + i + " + " + (n - i)).append('\n');
					flag = true;
					break;
				}
			}

			if (!flag) {
				sb.append("Goldbach's conjecture is wrong.").append('\n');
			}
		}

		System.out.println(sb);
	}
}
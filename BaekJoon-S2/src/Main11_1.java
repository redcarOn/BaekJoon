
//No.9020 - 시간단축
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11_1 {
	public static boolean[] arr = new boolean[10001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		prime();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			int first = n / 2;
			int second = n / 2;

			while (true) {
				if (!arr[first] && !arr[second]) {
					sb.append(first + " " + second).append('\n');
					break;
				}
				first--;
				second++;
			}
		}
		System.out.println(sb);
	}

	public static void prime() {
		arr[0] = arr[1] = true;

		for (int i = 2; i <= Math.sqrt(arr.length); i++) {
			if (arr[i]) {
				continue;
			}
			for (int j = i * i; j < arr.length; j += i) {
				arr[j] = true;
			}
		}
	}
}
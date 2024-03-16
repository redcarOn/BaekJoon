
//No.9020
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11 {
	public static StringBuilder sb;
	public static boolean[] arr = new boolean[10001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		prime();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			find(n / 2);
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

	public static void find(int n) {
		for (int i = 0; i < n; i++) {
			int first = n - i;
			int second = n + i;
			
			if (!arr[first] && !arr[second]) {
				sb.append(first + " " + second).append('\n');
				break;
			}
		}
	}
}
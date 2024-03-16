
//No.4948
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10_1 {
	public static boolean[] arr = new boolean[246913];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		find();

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				break;
			}
			int count = 0;

			for (int i = n + 1; i <= n * 2; i++) {
				if (!arr[i]) {
					count++;
				}
			}

			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}

	public static void find() {
		arr[0] = arr[1] = true;

		for (int i = 2; i <= Math.sqrt(arr.length); i++) {
			if (arr[i]) {
				continue;
			}
			for (int j = i * i; j <= arr.length; j += i) {
				arr[j] = true;
			}
		}
	}
}
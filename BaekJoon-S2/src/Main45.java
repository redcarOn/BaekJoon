
//No.17103
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main45 {
	public static boolean[] arr = new boolean[1000001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		find();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			sb.append(check(N)).append('\n');
		}
		System.out.println(sb);
	}

	public static void find() {
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

	public static int check(int n) {
		int count = 0;

		for (int i = 2; i <= n / 2; i++) {
			if (!(arr[i] || arr[n - i])) {
				count++;
			}
		}
		return count;
	}
}

//No.4948
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10 {
	public static boolean[] arr;
	public static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int input;

		while ((input = Integer.parseInt(br.readLine())) != 0) {
			int n = input;
			arr = new boolean[(n * 2) + 1];

			sb.append(find(n)).append('\n');
		}
		System.out.println(sb);
	}

	public static int find(int n) {
		arr[0] = arr[1] = true;
		count = 0;

		for (int i = 2; i <= Math.sqrt(n * 2); i++) {
			if (arr[i]) {
				continue;
			}
			for (int j = i * i; j <= n * 2; j = j + i) {
				arr[j] = true;
			}
		}

		for (int i = n + 1; i <= n * 2; i++) {
			if (!arr[i]) {
				count++;
			}
		}
		return count;
	}
}
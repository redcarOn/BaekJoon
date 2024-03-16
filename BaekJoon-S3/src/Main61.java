
//No.1788
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main61 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[2000001];
		arr[999999] = 1;
		arr[1000000] = 0;
		arr[1000001] = 1;
		int idx = 2;

		for (int i = 1000002; i < 1000001 + Math.abs(n); i++) {
			arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000000;
			arr[1000000 - idx] = arr[i];
			idx++;

		}
		if (n > 0) {
			sb.append(1).append('\n');
		} else if (n == 0) {
			sb.append(0).append('\n');
		} else {
			if (Math.abs(n) % 2 == 0) {
				sb.append(-1).append('\n');
			} else {
				sb.append(1).append('\n');
			}
		}

		sb.append(arr[n + 1000000]);
		System.out.println(sb);
	}
}
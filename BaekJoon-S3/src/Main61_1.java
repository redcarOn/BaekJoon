
//No.1788
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main61_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[1000001];
		arr[0] = 0;
		arr[1] = 1;

		for (int i = 2; i <= Math.abs(n); i++) {
			arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000000;
		}

		if (n > 0) {
			sb.append(1).append('\n');
			sb.append(arr[n]);
		} else if (n == 0) {
			sb.append(0).append('\n');
			sb.append(arr[0]);
		} else {
			if (Math.abs(n) % 2 == 0) {
				sb.append(-1).append('\n');
			} else {
				sb.append(1).append('\n');
			}
			sb.append(arr[Math.abs(n)]);
		}
		System.out.println(sb);
	}
}
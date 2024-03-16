
//No.1003
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main03 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		int[] test = new int[T];
		int max = 0;

		for (int i = 0; i < T; i++) {
			test[i] = Integer.parseInt(br.readLine());
			if (max < test[i]) {
				max = test[i];
			}
		}

		int[] arr = new int[41];
		arr[0] = 0;
		arr[1] = 1;

		for (int i = 2; i <= max; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}

		for (int i = 0; i < T; i++) {
			if (test[i] == 0) {
				sb.append(1 + " " + 0);
			} else {
				sb.append(arr[test[i] - 1] + " " + arr[test[i]]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}

//No.1107(리모컨) - 브루트포스★
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main04 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[10];

		if (M > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < M; i++) {
				arr[Integer.parseInt(st.nextToken())] = true;
			}
		}

		int ans = Math.abs(N - 100);

		for (int i = 0; i <= 999999; i++) {
			String str = String.valueOf(i);
			int len = str.length();

			boolean flag = false;
			for (int j = 0; j < len; j++) {
				if (arr[str.charAt(j) - '0']) {
					flag = true;
					break;
				}
			}

			if (!flag) {
				int min = Math.abs(N - i) + len;
				ans = Math.min(min, ans);
			}
		}
		System.out.println(ans);
	}
}
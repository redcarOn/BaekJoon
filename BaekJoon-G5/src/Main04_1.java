
//No.1107(리모컨) - 브루트포스★ - 시간단축
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main04_1 {
	public static int N, M, ans;
	public static boolean[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = new boolean[10];

		if (M > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < M; i++) {
				arr[Integer.parseInt(st.nextToken())] = true;
			}
		}

		ans = Math.abs(N - 100);
		recur(0, 0);

		System.out.println(ans);
	}

	public static void recur(int cur, int touch) {
		if (cur > 0) {
			int cnt = Math.abs(N - touch) + cur;
			ans = Math.min(ans, cnt);
		}

		if (cur >= 6) {
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (!arr[i]) {
				recur(cur + 1, touch * 10 + i);
			}
		}
	}
}
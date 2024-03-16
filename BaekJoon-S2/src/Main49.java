
//No.11501(주식)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main49 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		int[] arr;

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine()); // 날의 수
			arr = new int[N];
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken()); // 날 별 주가
			}

			sb.append(greedy(arr, N)).append('\n');
		}
		System.out.println(sb);
	}

	public static long greedy(int[] arr, int N) {
		long max = 0; // 최고주가
		long ans = 0; // 이익

		for (int i = N - 1; i >= 0; i--) {
			if (max < arr[i]) {
				max = arr[i];
			} else {
				ans += (max - arr[i]);
			}
		}
		return ans;
	}
}
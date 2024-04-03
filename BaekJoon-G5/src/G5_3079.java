
// No.3079(입국심사) - 41
// 이분탐색 - 매개변수 탐색
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_3079 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] times = new long[N];
		long min = Long.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			times[i] = Long.parseLong(br.readLine());
			min = Math.min(min, times[i]);
		}

		long left = min;
		long right = min * M;
		;
		long ans = Long.MAX_VALUE;

		while (left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;

			for (long time : times) {
				sum += mid / time;

				if (sum >= M) {
					break;
				}
			}

			if (sum >= M) {
				right = mid - 1;
				ans = Math.min(ans, mid);
			} else {
				left = mid + 1;
			}
		}
		System.out.println(ans);
	}
}
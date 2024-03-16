
//No.2792(보석 상자) - 이분탐색
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main73 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[M];

		int min = 1;
		int max = 0;

		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}

		int ans = 0;

		while (min <= max) {
			int mid = (min + max) / 2;
			int sum = 0;

			for (int j : arr) {
				sum += j / mid;

				if (j % mid != 0) {
					sum++;
				}
			}

			if (sum > N) {
				min = mid + 1;
			} else {
				max = mid - 1;
				ans = mid;
			}
		}
		System.out.println(ans);
	}
}
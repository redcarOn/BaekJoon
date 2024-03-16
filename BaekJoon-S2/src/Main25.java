
//No.2512
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main25 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");

		int min = 0;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}

		int M = Integer.parseInt(br.readLine());

		while (min <= max) {
			int mid = (min + max) / 2;
			long money = 0;

			for (int idx = 0; idx < N; idx++) {
				if (arr[idx] > mid) {
					money += mid;
				} else {
					money += arr[idx];
				}
			}

			if (money > M) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		System.out.println(max);
	}
}
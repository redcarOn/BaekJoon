
//No.16401(과자 나눠주기)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main71 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int min = 0;
		int max = 0;
		long sum = 0;

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(arr[i], max);
			sum += arr[i];
		}

		if (sum < M) {
			System.out.println(0);
			return;
		}

		int result = 0;

		while (min <= max) {
			int mid = (min + max) / 2;

			if (mid == 0) {
				mid++;
			}
			int count = 0;

			for (int candy : arr) {
				count += candy / mid;
			}

			if (count < M) {
				max = mid - 1;
			} else {
				min = mid + 1;
				result = mid;
			}
		}
		System.out.println(result);
	}
}
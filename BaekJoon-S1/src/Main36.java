
//No.2343(기타 레슨) - 이분탐색
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main36 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int min = 0;
		int max = 0;

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max += arr[i];
			min = Math.max(min, arr[i]);
		}

		while (min <= max) {
			int mid = (min + max) / 2;
			int cnt = 0;
			int sum = 0;

			for (int lec : arr) {
				if (sum + lec > mid) {
					sum = 0;
					cnt++;
				}
				sum += lec;
			}

			if (sum != 0) {
				cnt++;
			}

			if (cnt > M) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}

		System.out.println(min);
	}
}
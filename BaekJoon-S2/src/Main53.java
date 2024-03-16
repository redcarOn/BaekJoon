
//No.6236(용돈 관리)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main53 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		int min = 1;
		int max = 1;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			min = Math.max(min, arr[i]);
			max += arr[i];
		}

		while (min <= max) {
			int mid = (min + max) / 2;
			int money = 0;
			int cnt = 1;

			for (int i = 0; i < N; i++) {
				money += arr[i];

				if (money > mid) {
					money = arr[i];
					cnt++;
				}
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

//No.2805
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main03_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int min = 0;
		int max = Integer.MIN_VALUE;

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(arr[i], max);
		}

		int result = 0;
		while (min <= max) {
			int mid = (min + max) / 2;
			long len = 0;

			for (int tree : arr) {
				if (tree > mid) {
					len += tree - mid;
				}
			}

			if (len < M) {
				max = mid - 1;
			} else {
				min = mid + 1;
				result = mid;
			}
		}
		System.out.println(result);
	}
}
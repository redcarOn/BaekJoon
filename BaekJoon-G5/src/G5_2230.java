
// No.2230(수 고르기) - 46
// 정렬 + 투포인터
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_2230 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		int ans = Integer.MAX_VALUE;

		int left = 0;
		int right = 0;

		while (right < N) {
			int diff = arr[right] - arr[left];

			if (diff > M) {
				ans = Math.min(ans, diff);
				left++;
			} else if (diff == M) {
				ans = M;
				break;
			} else {
				right++;
			}
		}

		System.out.println(ans);
	}
}

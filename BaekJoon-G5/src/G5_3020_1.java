
// No.3020(개똥벌레) - 56_1
// 이분탐색
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_3020_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[] up = new int[N / 2];
		int[] down = new int[N / 2];

		for (int i = 0; i < N / 2; i++) {
			up[i] = Integer.parseInt(br.readLine());
			down[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(up);
		Arrays.sort(down);

		int min = N;
		int count = 0;

		for (int i = 1; i <= H; i++) {
			int total = binarySearch(0, N / 2, i, up) + binarySearch(0, N / 2, H - i + 1, down);

			if (total < min) {
				min = total;
				count = 1;
			} else if (total == min) {
				count++;
			}
		}

		System.out.println(min + " " + count);
		br.close();
	}

	static int binarySearch(int left, int right, int height, int[] arr) {
		while (left < right) {
			int mid = (left + right) / 2;

			if (arr[mid] >= height) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return arr.length - right;
	}
}
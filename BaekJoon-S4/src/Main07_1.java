
//No.10816
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main07_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int key = Integer.parseInt(st.nextToken());
			sb.append(upperBound(arr, 0, N, key) - lowerBound(arr, 0, N, key) + " ");
		}
		System.out.println(sb);
	}

	public static int lowerBound(int[] arr, int start, int end, int key) {
		while (start < end) {
			int mid = (start + end) / 2;

			if (key <= arr[mid]) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}

	public static int upperBound(int[] arr, int start, int end, int key) {
		while (start < end) {
			int mid = (start + end) / 2;

			if (key >= arr[mid]) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return start;
	}
}

//No. 1920
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main03 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

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
			int com = Integer.parseInt(st.nextToken());
			sb.append(binarySearch(arr, 0, (arr.length - 1), com)).append("\n");
		}
		System.out.print(sb);
	}

	public static int binarySearch(int[] arr, int start, int end, int N) {
		if (start > end) {
			return 0;
		} else {
			int mid = (start + end) / 2;
			if (arr[mid] == N) {
				return 1;
			} else if (arr[mid] > N) {
				return binarySearch(arr, start, mid - 1, N);
			} else {
				return binarySearch(arr, mid + 1, end, N);
			}
		}
	}
}
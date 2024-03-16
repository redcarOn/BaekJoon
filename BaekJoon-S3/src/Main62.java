
//No.7795
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main62 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		int N, M, count;
		int[] A;
		int[] B;

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			A = new int[N];
			B = new int[M];
			count = 0;

			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				A[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(A);

			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				B[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(B);

			for (int j = 0; j < N; j++) {
				count += binarySearch(B, 0, B.length - 1, A[j]);
			}
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}

	public static int binarySearch(int[] arr, int start, int end, int N) {
		while (start <= end) {
			int mid = (start + end) / 2;

			if (arr[mid] < N) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return start;
	}
}
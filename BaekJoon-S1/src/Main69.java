
//No.11497(통나무 건너뛰기) - 그리디 알고리즘
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main69 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		int N;
		int[] arr;

		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);

			sb.append(func(arr, N)).append('\n');
		}
		System.out.println(sb);
	}

	public static int func(int[] arr, int N) {
		int[] seq = new int[N];
		int start = 0;
		int end = N - 1;

		for (int i = 0; i < N; i++) {
			if (i % 2 == 0) {
				seq[start++] = arr[i];
			} else {
				seq[end--] = arr[i];
			}
		}

		int min = Math.abs(seq[N - 1] - seq[0]);

		for (int i = 1; i < N; i++) {
			min = Math.max(min, Math.abs(seq[i] - seq[i - 1]));
		}

		return min;
	}
}
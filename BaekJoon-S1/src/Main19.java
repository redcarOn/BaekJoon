
//No.1946(신입 사원) - GreedyMethod(2차원배열)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main19 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		int[][] arr;

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N][2];

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});

			sb.append(func(arr, N)).append('\n');
		}

		System.out.println(sb);
	}

	public static int func(int[][] arr, int N) {
		int min = arr[0][1];
		int cnt = 0;

		for (int i = 1; i < N; i++) {
			if (min < arr[i][1]) {
				cnt++;
				continue;
			}
			min = arr[i][1];
		}

		return N - cnt;
	}
}

//No.18111
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main19 {
	public static int[][] arr;
	public static int[][] ans;
	public static int N, M, B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(arr[i][j], min);
				max = Math.max(arr[i][j], max);
			}
		}

		ans = new int[max + 1][2];
		mineCraft(min, max);

		int minTime = Integer.MAX_VALUE;
		int height = 0;

		for (int i = min; i <= max; i++) {
			if (ans[i][0] < 0) {
				continue;
			} else {
				if (minTime >= ans[i][0]) {
					minTime = ans[i][0];
					height = i;
				}
			}
		}
		sb.append(minTime + " " + height);
		System.out.println(sb);
	}

	public static void mineCraft(int min, int max) {
		while (min <= max) {
			ans[min][1] = min;
			int time = 0;
			int block = B;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] < min) {
						time += (min - arr[i][j]);
						block -= (min - arr[i][j]);
					} else {
						time += (arr[i][j] - min) * 2;
						block += (arr[i][j] - min);
					}
				}
			}
			if (block < 0) {
				ans[min][0] = -1;
			} else {
				ans[min][0] = time;
			}
			min++;
		}
	}
}
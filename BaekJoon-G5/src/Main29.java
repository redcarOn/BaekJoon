
//No.2096(내려가기) - DP
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main29 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] max = new int[N + 1][3];
		int[][] min = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					max[i][0] = Math.max(max[i - 1][0], max[i - 1][1]) + arr[i][j];
					min[i][0] = Math.min(min[i - 1][0], min[i - 1][1]) + arr[i][j];
				} else if (j == 1) {
					max[i][1] = Math.max(max[i - 1][0], Math.max(max[i - 1][1], max[i - 1][2])) + arr[i][j];
					min[i][1] = Math.min(min[i - 1][0], Math.min(min[i - 1][1], min[i - 1][2])) + arr[i][j];
				} else {
					max[i][2] = Math.max(max[i - 1][1], max[i - 1][2]) + arr[i][j];
					min[i][2] = Math.min(min[i - 1][1], min[i - 1][2]) + arr[i][j];
				}
			}
		}
		int high = Integer.MIN_VALUE;
		int low = Integer.MAX_VALUE;

		for (int i = 0; i < 3; i++) {
			high = Math.max(high, max[N][i]);
			low = Math.min(low, min[N][i]);
		}

		System.out.println(high + " " + low);
	}
}
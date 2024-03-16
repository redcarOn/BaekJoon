
//No.1004
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main26 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int x1, y1, x2, y2;
		int[][] arr;
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			int n = Integer.parseInt(br.readLine());
			arr = new int[n][3];
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
				arr[j][2] = Integer.parseInt(st.nextToken());
			}

			sb.append(find(x1, y1, x2, y2, arr)).append('\n');
		}
		System.out.println(sb);
	}

	public static int find(int x1, int y1, int x2, int y2, int[][] arr) {
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			int start = (int) (Math.pow(arr[i][0] - x1, 2) + Math.pow(arr[i][1] - y1, 2));
			int end = (int) (Math.pow(arr[i][0] - x2, 2) + Math.pow(arr[i][1] - y2, 2));
			int bound = (int) (Math.pow(arr[i][2], 2));

			if (start < bound && end > bound) {
				count++;
			} else if (start > bound && end < bound) {
				count++;
			}
		}
		return count;
	}
}
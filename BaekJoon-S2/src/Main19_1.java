
//No.18111 - 시간단축
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main19_1 {
	public static int[] arr;
	public static int N, M, B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		arr = new int[257];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[Integer.parseInt(st.nextToken())]++;
			}
		}

		int time = Integer.MAX_VALUE;
		int height = -1;

		for (int i = 0; i < 257; i++) {
			int high = 0, low = 0;

			for (int j = 0; j < 257; j++) {
				if (arr[j] == 0 || i == j) {
					continue;
				}

				if (i > j) {
					low += (i - j) * arr[j];
				} else if (i < j) {
					high += (j - i) * arr[j];
				}
			}

			if (high + B >= low) {
				int tmp = (high * 2) + low;

				if (time >= tmp) {
					time = tmp;
					height = i;
				}
			}
		}
		sb.append(time + " " + height);
		System.out.println(sb);
	}
}
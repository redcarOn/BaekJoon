
//No.2564(경비원) - 많은 조건 분기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main68 {
	public static int C, R, N;
	public static int[] arr;
	public static int size;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1];
		size = C * 2 + R * 2;

		for (int i = 0; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());

			if (dir == 1) {
				arr[i] = len;
			} else if (dir == 2) {
				arr[i] = C * 2 + R - len;
			} else if (dir == 3) {
				arr[i] = C * 2 + R * 2 - len;
			} else if (dir == 4) {
				arr[i] = C + len;
			}
		}

		System.out.println(length(arr[N]));
	}

	public static int length(int idx) {
		int sum = 0;
		int len;

		for (int i = 0; i < N; i++) {
			len = Math.abs(idx - arr[i]);
			sum += Math.min(len, size - len);
		}
		return sum;
	}
}
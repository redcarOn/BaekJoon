
//No.2467(용액) - 투포인터
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main34 {
	public static int N;
	public static int[] arr;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		func();

		System.out.println(sb);
	}

	public static void func() {
		int start = 0;
		int end = N - 1;

		int small = 0;
		int big = 0;
		int min = Integer.MAX_VALUE;

		while (start < end) {
			int tmp = arr[start] + arr[end];
			int sum = Math.abs(tmp);

			if (sum < min) {
				min = sum;
				small = arr[start];
				big = arr[end];
			}

			if (tmp > 0) {
				end--;
			} else if (tmp < 0) {
				start++;
			} else {
				break;
			}
		}

		sb.append(small).append(" ").append(big);
	}
}

//No.11441
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main64 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			arr[i] = arr[i - 1] + tmp;
		}

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			sb.append(arr[end] - arr[start - 1]).append('\n');
		}
		System.out.println(sb);
	}
}
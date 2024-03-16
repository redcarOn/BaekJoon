
//No.1946(신입 사원) - GreedyMethod(1차원배열) - Best
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main19_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		int[] arr;

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N + 1];

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());

				arr[first] = second;
			}

			int cnt = 1;
			int min = arr[1];

			for (int j = 2; j <= N; j++) {
				if (min > arr[j]) {
					min = arr[j];
					cnt++;
				}
			}

			sb.append(cnt).append('\n');
		}

		System.out.println(sb);
	}
}
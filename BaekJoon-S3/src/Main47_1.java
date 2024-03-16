
//No.10451 - 배열 + DFS★
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main47_1 {
	public static int[] arr;
	public static boolean[] visited;
	public static int N, count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			count = 0;
			arr = new int[N + 1];
			visited = new boolean[N + 1];

			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			for (int k = 1; k <= N; k++) {
				if (!visited[k]) {
					DFS(k);
					count++;
				}
			}
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}

	public static void DFS(int num) {
		if (visited[num]) {
			return;
		}
		visited[num] = true;
		DFS(arr[num]);
	}
}
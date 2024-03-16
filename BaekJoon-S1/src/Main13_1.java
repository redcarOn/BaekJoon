
//No.1325(효율적인 해킹) - DFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main13_1 {
	public static int N, M;
	public static int[] cnt;
	public static boolean[] isvisited;
	public static int max;
	public static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = new int[N + 1];
		graph = new ArrayList<>();
		max = 0;

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			graph.get(A).add(B);
		}

		for (int i = 1; i <= N; i++) {
			isvisited = new boolean[N + 1];
			dfs(i);
		}

		for (int i = 1; i <= N; i++) {
			max = Math.max(cnt[i], max);
		}

		for (int i = 1; i <= N; i++) {
			if (cnt[i] == max) {
				sb.append(i + " ");
			}
		}

		System.out.println(sb);
	}

	public static void dfs(int start) {
		isvisited[start] = true;

		for (int node : graph.get(start)) {
			if (!isvisited[node]) {
				cnt[node]++;
				dfs(node);
			}
		}

	}
}
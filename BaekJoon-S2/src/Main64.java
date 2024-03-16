
//No.24480(알고리즘 수업 - 깊이 우선 탐색 2)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main64 {
	public static ArrayList<ArrayList<Integer>> graph;
	public static int N, M, R;
	public static int[] seq;
	public static boolean[] visited;
	public static int idx = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		seq = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(graph.get(i), Collections.reverseOrder());
		}

		dfs(R);

		for (int i = 1; i <= N; i++) {
			sb.append(seq[i]).append('\n');
		}
		System.out.println(sb);
	}

	public static void dfs(int start) {
		visited[start] = true;
		seq[start] = idx++;

		for (int node : graph.get(start)) {
			if (!visited[node]) {
				dfs(node);
			}
		}
	}
}
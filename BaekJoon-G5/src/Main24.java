
//No.13023(ABCDE) - DFS + 백트래킹
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main24 {
	public static int N;
	public static ArrayList<ArrayList<Integer>> graph;
	public static boolean[] visited;
	public static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		graph = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}

		visited = new boolean[N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		for (int i = 0; i < N; i++) {
			dfs(i, 1);

			if (flag) {
				break;
			}
		}

		if (flag) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	public static void dfs(int start, int depth) {
		if (depth == 5) {
			flag = true;
			return;
		}

		visited[start] = true;
		for (int node : graph.get(start)) {
			if (!visited[node]) {
				dfs(node, depth + 1);
			}
		}
		visited[start] = false;
	}
}
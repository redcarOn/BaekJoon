
//No.5567(결혼식) - DFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main51 {
	public static ArrayList<ArrayList<Integer>> graph;
	public static boolean[] visit;
	public static int n;
	public static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		graph = new ArrayList<>();

		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		visit = new boolean[n + 1];
		cnt = 0;
		dfs(1, 0);

		for (int i = 2; i <= n; i++) {
			if (visit[i]) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	public static void dfs(int start, int depth) {
		if (depth == 2) {
			return;
		}

		for (int val : graph.get(start)) {
			visit[val]=true;
			dfs(val, depth + 1);
		}
	}
}
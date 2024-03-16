
//No.2644
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main30 {
	public static ArrayList<ArrayList<Integer>> graph;
	public static boolean[] visit;
	public static int count = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		graph = new ArrayList<>();
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		visit = new boolean[n + 1];
		count = 0;

		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph.get(x).add(y);
			graph.get(y).add(x);
		}

		DFS(start, end, 0);

		System.out.println(count);
	}

	public static void DFS(int start, int end, int depth) {
		visit[start] = true;

		if (start == end) {
			count = depth;
			return;
		}

		for (int node : graph.get(start)) {
			if (!visit[node]) {
				DFS(node, end, depth + 1);
			}
		}
	}
}

//NO.24479
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main37 {
	public static ArrayList<ArrayList<Integer>> graph;
	public static boolean[] visit;
	public static int N, M, R;
	public static int idx = 1;
	public static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		visit = new boolean[N + 1];
		num = new int[N + 1];

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
			Collections.sort(graph.get(i));
		}

		DFS(R);

		for (int i = 1; i <= N; i++) {
			sb.append(num[i]).append('\n');
		}

		System.out.println(sb);
	}

	public static void DFS(int start) {
		visit[start] = true;
		num[start] = idx++;

		for (int node : graph.get(start)) {
			if (!visit[node]) {
				DFS(node);
			}
		}
	}
}
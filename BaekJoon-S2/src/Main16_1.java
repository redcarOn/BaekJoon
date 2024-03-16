
//No.11725 - DFS + 인접리스트
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main16_1 {
	public static ArrayList<ArrayList<Integer>> graph;
	public static boolean[] isvisited;
	public static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		graph = new ArrayList<>();

		int N = Integer.parseInt(br.readLine());
		parent = new int[N + 1];
		isvisited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graph.get(x).add(y);
			graph.get(y).add(x);
		}

		DFS(1);

		for (int i = 2; i <= N; i++) {
			sb.append(parent[i]).append('\n');
		}
		System.out.println(sb);
	}

	public static void DFS(int index) {
		isvisited[index] = true;

		for (int node : graph.get(index)) {
			if (!isvisited[node]) {
				parent[node] = index;
				DFS(node);
			}
		}
	}
}
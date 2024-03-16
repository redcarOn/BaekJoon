
//No.2606 - 인접리스트 + DFS(Recursive)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main07_4 {
	public static ArrayList<ArrayList<Integer>> graph;
	public static boolean[] visit;
	public static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int C = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		visit = new boolean[C + 1];

		for (int i = 0; i <= C; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graph.get(x).add(y);
			graph.get(y).add(x);
		}

		DFS(1, C);
		System.out.println(count);
	}

	public static void DFS(int num, int C) {
		visit[num] = true;

		for (int node : graph.get(num)) {
			if (visit[node]) {
				continue;
			}
			visit[node] = true;
			count++;
			DFS(node, C);
		}
	}
}
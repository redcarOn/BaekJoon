
//No.11724 - DFS + 인접립스트
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main08 {
	public static ArrayList<ArrayList<Integer>> graph;
	public static boolean[] isvisited;
	public static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		isvisited = new boolean[N + 1];
		count = 0;

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
			if (!isvisited[i]) {
				DFS(i);
				count++;
			}
		}
		System.out.println(count);
	}

	public static void DFS(int num) {
		isvisited[num] = true;

		for (int node : graph.get(num)) {
			if (isvisited[node]) {
				continue;
			}
			DFS(node);
		}
	}
}
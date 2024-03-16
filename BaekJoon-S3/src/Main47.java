
//No.10451 - 인접리스트 + DFS★
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main47 {
	public static ArrayList<ArrayList<Integer>> graph;
	public static boolean[] visited;
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			graph = new ArrayList<>();
			visited = new boolean[N + 1];

			for (int j = 0; j <= N; j++) {
				graph.add(new ArrayList<Integer>());
			}

			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				int num = Integer.parseInt(st.nextToken());
				graph.get(j).add(num);
			}
			int count = 0;
			for (int k = 1; k <= N; k++) {
				if (DFS(k)) {
					count++;
				}
			}
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}

	public static boolean DFS(int num) {
		if (visited[num]) {
			return false;
		}
		visited[num] = true;
		for (int val : graph.get(num)) {
			if (!visited[val]) {
				DFS(val);
			}
		}
		return true;
	}
}
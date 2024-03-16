
//No.11724 - DFS + 2차원배열
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main08_1 {
	public static boolean[][] graph;
	public static boolean[] isvisited;
	public static int count;
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new boolean[N + 1][N + 1];
		isvisited = new boolean[N + 1];
		count = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u][v] = graph[v][u] = true;
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

		for (int i = 1; i <= N; i++) {
			if (!isvisited[i] && graph[num][i]) {
				DFS(i);
			}
		}
	}
}
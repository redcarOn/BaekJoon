
//No.15900(나무 탈출) - DFS(boolean)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main72 {
	public static int N;
	public static ArrayList<ArrayList<Integer>> graph;
	public static boolean[] isvisited;
	public static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		graph = new ArrayList<>();
		N = Integer.parseInt(br.readLine());
		isvisited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		DFS(1, 0);

		if (cnt % 2 == 1) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	public static void DFS(int num, int depth) {
		boolean flag = false;
		isvisited[num] = true;
		for (int node : graph.get(num)) {
			if (!isvisited[node]) {
				flag = true;
				DFS(node, depth + 1);
			}
		}

		if (!flag) {
			cnt += depth;
			return;
		}
	}
}
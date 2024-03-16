
//No.2606 - 인접행렬 + BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main07_2 {
	public static int[][] graph;
	public static Queue<Integer> queue;
	public static boolean[] visit;
	public static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int C = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		graph = new int[C + 1][C + 1];
		visit = new boolean[C + 1];

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graph[x][y] = graph[y][x] = 1;
		}

		BFS(1, C);
		System.out.println(count);
	}

	public static void BFS(int num, int C) {
		queue = new LinkedList<Integer>();

		visit[num] = true;
		queue.offer(num);

		while (!queue.isEmpty()) {
			int temp = queue.poll();

			for (int i = 1; i <= C; i++) {
				if (graph[temp][i] == 1 && visit[i] == false) {
					count++;
					queue.offer(i);
					visit[i] = true;
				}
			}
		}
	}
}
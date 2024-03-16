
//No.2606 - 인접행렬 + DFS(Stack)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main07_1 {
	public static int[][] graph;
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

		DFS(1, C);
		System.out.println(count);
	}

	public static void DFS(int num, int C) {
		Stack<Integer> stack = new Stack<>();
		stack.push(num);
		visit[num] = true;

		while (!stack.isEmpty()) {
			int tmp = stack.peek();

			for (int i = 1; i <= C; i++) {
				if (graph[tmp][i] == 1 && !visit[i]) {
					stack.push(i);
					count++;
					DFS(i, C);
				}
			}
			stack.pop();
		}
	}
}
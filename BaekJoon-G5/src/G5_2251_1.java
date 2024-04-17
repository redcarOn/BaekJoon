
// No.2251(물통) - 59
// BFS 축약
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_2251_1 {
	static int[] bottle;
	static boolean[][] visited;
	static boolean[] answer;
	static int[] sender = { 0, 0, 1, 1, 2, 2 };
	static int[] receiver = { 1, 2, 0, 2, 0, 1 };

	static class Bottle {
		int a, b;

		Bottle(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		bottle = new int[3];

		for (int i = 0; i < 3; i++) {
			bottle[i] = Integer.parseInt(st.nextToken());
		}

		visited = new boolean[201][201];
		answer = new boolean[201];

		BFS();

		for (int i = 0; i < answer.length; i++) {
			if (answer[i]) {
				sb.append(i).append(' ');
			}
		}

		System.out.println(sb);
		br.close();
	}

	static void BFS() {
		Queue<Bottle> queue = new ArrayDeque<>();
		queue.offer(new Bottle(0, 0));
		visited[0][0] = true;
		answer[bottle[2]] = true;

		while (!queue.isEmpty()) {
			Bottle now = queue.poll();
			int A = now.a;
			int B = now.b;
			int C = bottle[2] - A - B;

			for (int i = 0; i < 6; i++) {
				int[] next = { A, B, C };
				next[receiver[i]] += next[sender[i]];
				next[sender[i]] = 0;

				if (next[receiver[i]] > bottle[receiver[i]]) {
					next[sender[i]] = next[receiver[i]] - bottle[receiver[i]];
					next[receiver[i]] = bottle[receiver[i]];
				}

				if (!visited[next[0]][next[1]]) {
					visited[next[0]][next[1]] = true;
					queue.offer(new Bottle(next[0], next[1]));

					if (next[0] == 0) {
						answer[next[2]] = true;
					}
				}
			}
		}
	}
}
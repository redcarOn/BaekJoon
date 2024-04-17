
// No.2251(물통) - 59
// DFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_2251_2 {
	static int[] bottle;
	static boolean[][] visited;
	static boolean[] answer;
	static int[] sender = { 0, 0, 1, 1, 2, 2 };
	static int[] receiver = { 1, 2, 0, 2, 0, 1 };

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

		DFS(0, 0);

		for (int i = 0; i < answer.length; i++) {
			if (answer[i]) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);
		br.close();
	}

	static void DFS(int a, int b) {
		if (visited[a][b]) {
			return;
		}
		visited[a][b] = true;
		int c = bottle[2] - a - b;

		if (a == 0) {
			answer[c] = true;
		}

		for (int i = 0; i < 6; i++) {
			int[] next = { a, b, c };
			next[receiver[i]] += next[sender[i]];
			next[sender[i]] = 0;

			if (next[receiver[i]] > bottle[receiver[i]]) {
				next[sender[i]] = next[receiver[i]] - bottle[receiver[i]];
				next[receiver[i]] = bottle[receiver[i]];
			}
			DFS(next[0], next[1]);
		}
	}
}
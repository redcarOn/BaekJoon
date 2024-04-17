
// No.2251(물통) - 59
// BFS 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_2251 {
	static class Bottle {
		int a, b, c;

		Bottle(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	static int maxA, maxB, maxC;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		maxA = Integer.parseInt(st.nextToken());
		maxB = Integer.parseInt(st.nextToken());
		maxC = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();

		BFS();

		Collections.sort(list);

		for (int ans : list) {
			sb.append(ans + " ");
		}

		System.out.println(sb.toString());
		br.close();
	}

	static void BFS() {
		Queue<Bottle> queue = new ArrayDeque<>();
		boolean[][][] visited = new boolean[maxA + 1][maxB + 1][maxC + 1];
		queue.offer(new Bottle(0, 0, maxC));

		while (!queue.isEmpty()) {
			Bottle now = queue.poll();

			if (visited[now.a][now.b][now.c]) {
				continue;
			}

			if (now.a == 0) {
				list.add(now.c);
			}

			visited[now.a][now.b][now.c] = true;

			if (now.a + now.b <= maxA) {
				queue.offer(new Bottle(now.a + now.b, 0, now.c));
			} else {
				queue.offer(new Bottle(maxA, now.a + now.b - maxA, now.c));
			}

			if (now.a + now.c <= maxA) {
				queue.offer(new Bottle(now.a + now.c, now.b, 0));
			} else {
				queue.offer(new Bottle(maxA, now.b, now.a + now.c - maxA));
			}

			if (now.a + now.b <= maxB) {
				queue.offer(new Bottle(0, now.a + now.b, now.c));
			} else {
				queue.offer(new Bottle(now.a + now.b - maxB, maxB, now.c));
			}

			if (now.b + now.c <= maxB) {
				queue.offer(new Bottle(now.a, now.b + now.c, 0));
			} else {
				queue.offer(new Bottle(now.a, maxB, now.b + now.c - maxB));
			}

			if (now.a + now.c <= maxC) {
				queue.offer(new Bottle(0, now.b, now.a + now.c));
			} else {
				queue.offer(new Bottle(now.a + now.c - maxC, now.b, maxC));
			}

			if (now.b + now.c <= maxC) {
				queue.offer(new Bottle(now.a, 0, now.b + now.c));
			} else {
				queue.offer(new Bottle(now.a, now.b + now.c - maxC, maxC));
			}
		}
	}
}

//No.1446(지름길) - DFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main66_1 {
	public static class Path {
		int start;
		int end;
		int cost;

		public Path(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}

	public static int N, D;
	public static ArrayList<Path> list;
	public static boolean[] check;
	public static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			if (start > D || end > D) {
				continue;
			}

			list.add(new Path(start, end, cost));
		}

		check = new boolean[list.size()];
		dfs(0, D, 0);

		System.out.println(result);
	}

	public static void dfs(int now, int end, int distance) {
		if (now > end) {
			return;
		} else if (now == end) {
			result = Math.min(result, distance);
			return;
		} else {
			result = Math.min(result, distance + (end - now));
		}

		for (int i = 0; i < list.size(); i++) {
			if (!check[i]) {
				Path path = list.get(i);

				if (path.start == now) {
					check[i] = true;
					dfs(path.end, end, distance + path.cost);
					check[i] = false;
				}
			}
		}
		dfs(now + 1, end, distance + 1);
	}
}
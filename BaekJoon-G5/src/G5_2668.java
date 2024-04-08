
// No.2668(숫자고르기) - 53
// DFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class G5_2668 {
	static int N;
	static int[] arr;
	static boolean[] visited;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		visited = new boolean[N + 1];
		list = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= N; i++) {
			visited[i] = true;
			dfs(i, arr[i]);
			visited[i] = false;
		}

		sb.append(list.size()).append('\n');

		for (int num : list) {
			sb.append(num).append('\n');
		}

		System.out.println(sb.toString());
	}

	static void dfs(int start, int now) {
		if (!visited[now]) {
			visited[now] = true;
			dfs(start, arr[now]);
			visited[now] = false;
		} else if (now == start) {
			list.add(start);
		}
	}
}
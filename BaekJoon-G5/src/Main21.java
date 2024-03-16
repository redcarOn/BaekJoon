
//No.1068(트리) - DFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main21 {
	public static int N;
	public static ArrayList<ArrayList<Integer>> tree;
	public static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		tree = new ArrayList<>();
		int root = 0;

		for (int i = 0; i < N; i++) {
			tree.add(new ArrayList<>());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());

			if (n == -1) {
				root = i;
				continue;
			}

			tree.get(n).add(i);
		}

		int K = Integer.parseInt(br.readLine());

		if (K == root) {
			cnt = 0;
		} else {
			dfs(root, K);
		}

		System.out.println(cnt);
	}

	public static void dfs(int root, int K) {
		if (tree.get(root).contains(K)) {
			tree.get(root).remove(Integer.valueOf(K));
		}
		if (tree.get(root).isEmpty()) {
			cnt++;
			return;
		}

		for (int node : tree.get(root)) {
			dfs(node, K);
		}
	}
}
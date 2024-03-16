
//No.15666(N과 M 12) - ArrayList
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main52 {
	public static int N, M;
	public static ArrayList<Integer> list;
	public static int[] seq;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		seq = new int[M];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (!list.contains(num)) {
				list.add(num);
			}
		}
		Collections.sort(list);

		dfs(0, 0);
		System.out.println(sb);
	}

	public static void dfs(int start, int depth) {
		if (depth == M) {
			for (int val : seq) {
				sb.append(val + " ");
			}
			sb.append('\n');
			return;
		}

		for (int i = start; i < list.size(); i++) {
			seq[depth] = list.get(i);
			dfs(i, depth + 1);
		}
	}
}
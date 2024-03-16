
//No.15686(치킨 배달) - 백트래킹 + 브루트포스
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main11 {
	public static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static int N, M;
	public static int[][] arr;
	public static ArrayList<Node> house;
	public static ArrayList<Node> chicken;
	public static boolean[] check;
	public static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		house = new ArrayList<>();
		chicken = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] == 1) {
					house.add(new Node(i, j));
				} else if (arr[i][j] == 2) {
					chicken.add(new Node(i, j));
				}
			}
		}

		check = new boolean[chicken.size()];
		dfs(0, 0);

		System.out.println(min);
	}

	public static void dfs(int start, int depth) {
		if (depth == M) {
			int cnt = 0;
			for (int i = 0; i < house.size(); i++) {
				int tmp = Integer.MAX_VALUE;

				for (int j = 0; j < chicken.size(); j++) {
					if (check[j]) {
						int dis = Math.abs(house.get(i).r - chicken.get(j).r)
								+ Math.abs(house.get(i).c - chicken.get(j).c);
						tmp = Math.min(tmp, dis);
					}
				}
				cnt += tmp;
			}
			min = Math.min(min, cnt);
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			check[i] = true;
			dfs(i + 1, depth + 1);
			check[i] = false;
		}
	}
}
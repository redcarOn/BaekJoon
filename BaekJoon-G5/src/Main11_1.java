
//No.15686(치킨 배달) - 백트래킹 + 브루트포스 (중복계산제거)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main11_1 {
	public static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static int N, M, min;
	public static int[][] arr;
	public static ArrayList<Node> house;
	public static ArrayList<Node> chicken;
	public static int[] check;
	public static int[][] distance;

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

		distance = new int[house.size()][chicken.size()];
		check = new int[M];
		min = Integer.MAX_VALUE;
		func();
		dfs(0, 0);

		System.out.println(min);
	}

	public static void dfs(int start, int depth) {
		if (depth == M) {
			min = Math.min(min, cal());
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			check[depth] = i;
			dfs(i + 1, depth + 1);
		}
	}

	public static int cal() {
		int cnt = 0;

		for (int i = 0; i < house.size(); i++) {
			int tmp = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) {
				tmp = Math.min(tmp, distance[i][check[j]]);
			}
			cnt += tmp;
		}
		return cnt;
	}

	public static void func() {
		for (int i = 0; i < house.size(); i++) {
			for (int j = 0; j < chicken.size(); j++) {
				distance[i][j] = Math.abs(house.get(i).c - chicken.get(j).c)
						+ Math.abs(house.get(i).r - chicken.get(j).r);
			}
		}
	}
}
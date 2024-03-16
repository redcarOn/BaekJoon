
//No.2529(부등호) - 백트래킹
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main40 {
	public static int k;
	public static char[] arr;
	public static ArrayList<String> list;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		k = Integer.parseInt(br.readLine());
		arr = new char[k];
		visited = new boolean[10];
		list = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < k; i++) {
			arr[i] = st.nextToken().charAt(0);

		}

		dfs("", 0);
		Collections.sort(list);

		System.out.println(list.get(list.size() - 1));
		System.out.println(list.get(0));
	}

	public static void dfs(String num, int depth) {
		if (depth == k + 1) {
			list.add(num);
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (visited[i]) {
				continue;
			}
			if (depth == 0 || check(arr[depth - 1], Character.getNumericValue(num.charAt(depth - 1)), i)) {
				visited[i] = true;
				dfs(num + i, depth + 1);
				visited[i] = false;
			}
		}
	}

	public static boolean check(char n, int a, int b) {
		if (n == '>') {
			if (a < b) {
				return false;
			}
		}

		if (n == '<') {
			if (a > b) {
				return false;
			}
		}

		return true;
	}
}
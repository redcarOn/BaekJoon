
//No.2529(부등호) - 백트래킹(시간단축) - 부분탐색
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main40_1 {
	public static int k;
	public static String str;
	public static int[] arr;
	public static boolean[] visited;
	public static String min, max;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		k = Integer.parseInt(br.readLine());
		str = br.readLine();
		arr = new int[k + 1];
		visited = new boolean[10];

		for (int i = 0; i < 10; i++) {
			visited[i] = true;
			arr[0] = i;
			findMin(i, 1, 0);
			visited[i] = false;

			if (min != null) {
				break;
			}
		}

		arr = new int[k + 1];
		visited = new boolean[10];

		for (int i = 9; i >= 0; i--) {
			visited[i] = true;
			arr[0] = i;
			findMax(i, 1, 0);
			visited[i] = false;

			if (max != null) {
				break;
			}
		}

		sb.append(max).append('\n').append(min);
		System.out.println(sb);
	}

	public static void findMin(int start, int depth, int idx) {
		if (depth == k + 1) {
			if (min == null) {
				for (int num : arr) {
					sb.append(num);
				}
				min = sb.toString();
				sb = new StringBuilder();
			}
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (!visited[i]) {
				if (str.charAt(idx) == '<' && i > start) {
					visited[i] = true;
					arr[depth] = i;
					findMin(i, depth + 1, idx + 2);
					visited[i] = false;
				} else if (str.charAt(idx) == '>' && i < start) {
					visited[i] = true;
					arr[depth] = i;
					findMin(i, depth + 1, idx + 2);
					visited[i] = false;
				}
			}

			if (min != null) {
				return;
			}
		}
	}

	public static void findMax(int start, int depth, int idx) {
		if (depth == k + 1) {
			if (max == null) {
				for (int num : arr) {
					sb.append(num);
				}
				max = sb.toString();
				sb = new StringBuilder();
			}
			return;
		}

		for (int i = 9; i >= 0; i--) {
			if (!visited[i]) {
				if (str.charAt(idx) == '<' && i > start) {
					visited[i] = true;
					arr[depth] = i;
					findMax(i, depth + 1, idx + 2);
					visited[i] = false;
				} else if (str.charAt(idx) == '>' && i < start) {
					visited[i] = true;
					arr[depth] = i;
					findMax(i, depth + 1, idx + 2);
					visited[i] = false;
				}
			}

			if (max != null) {
				return;
			}
		}
	}
}
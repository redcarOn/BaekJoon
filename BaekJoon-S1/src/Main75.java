
//No.9934(완전 이진 트리) - 재귀
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main75 {
	public static int K;
	public static int[] arr;
	public static ArrayList<ArrayList<Integer>> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());
		arr = new int[(int) Math.pow(2, K) - 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		list = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			list.add(new ArrayList<>());
		}

		recur(0, arr.length - 1, 0);

		for (int i = 0; i < K; i++) {
			for (int node : list.get(i)) {
				sb.append(node).append(" ");
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}

	public static void recur(int start, int end, int depth) {
		if (depth == K) {
			return;
		}

		int mid = (start + end) / 2;

		list.get(depth).add(arr[mid]);

		recur(start, mid - 1, depth + 1);
		recur(mid + 1, end, depth + 1);
	}
}
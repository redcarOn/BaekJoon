
//No.2304(창고 다각형)★
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main56 {
	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		arr = new int[1001];
		int start = 1001;
		int end = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());

			arr[L] = H;
			start = Math.min(start, L);
			end = Math.max(end, L);
		}

		left(start, end);
		right(end, start);
		int area = 0;

		for (int i = start; i <= end; i++) {
			area += arr[i];
		}
		System.out.println(area);
	}

	public static void left(int start, int end) {
		Stack<Integer> stack = new Stack<>();
		int tmp = arr[start];

		for (int i = start + 1; i <= end; i++) {
			if (arr[i] < tmp) {
				stack.push(i);
			} else {
				while (!stack.isEmpty()) {
					arr[stack.pop()] = tmp;
				}
				tmp = arr[i];
			}
		}
	}

	public static void right(int start, int end) {
		Stack<Integer> stack = new Stack<>();
		int tmp = arr[start];

		for (int i = start - 1; i >= end; i--) {
			if (arr[i] < tmp) {
				stack.push(i);
			} else {
				while (!stack.isEmpty()) {
					arr[stack.pop()] = tmp;
				}
				tmp = arr[i];
			}
		}
	}
}
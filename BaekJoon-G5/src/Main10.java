
//No.11729 (하노이 탑 이동 순서) - 재귀
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10 {
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		sb.append((int) Math.pow(2, N) - 1).append('\n');
		hanoi(N, 1, 2, 3);

		System.out.println(sb);
	}

	public static void hanoi(int n, int start, int mid, int end) {
		if (n == 0) {
			return;
		}

		hanoi(n - 1, start, end, mid);
		sb.append(start).append(" ").append(end).append('\n');
		hanoi(n - 1, mid, start, end);
	}
}

//No.16953★★ - DFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main31_1 {
	public static Long A, B;
	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());

		DFS(A, 0);
		if (ans == 0) {
			System.out.println(-1);
		} else {
			System.out.println(ans + 1);
		}
	}

	public static void DFS(long a, int count) {
		if (a == B) {
			if (ans != 0) {
				ans = Math.min(ans, count);
			} else {
				ans = count;
			}
			return;
		}

		if (a > B) {
			return;
		}

		DFS(a * 10 + 1, count + 1);
		DFS(a * 2, count + 1);
	}
}
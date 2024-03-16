
//No.1072 (이분탐색)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main24_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long X = Integer.parseInt(st.nextToken());
		long Y = Integer.parseInt(st.nextToken());
		int Z = percent(X, Y);
		int ans = -1;
		int start = 0;
		int end = (int) 1e9;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (percent(X + mid, Y + mid) != Z) {
				ans = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		System.out.println(ans);
	}

	public static int percent(long x, long y) {
		return (int) (y * 100 / x);
	}
}
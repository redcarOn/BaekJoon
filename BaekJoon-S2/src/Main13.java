
//No.1541
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		int ans = Integer.MAX_VALUE;

		while (st.hasMoreTokens()) {
			int tmp = 0;

			StringTokenizer stAdd = new StringTokenizer(st.nextToken(), "+");

			while (stAdd.hasMoreTokens()) {
				tmp += Integer.parseInt(stAdd.nextToken());
			}

			if (ans == Integer.MAX_VALUE) {
				ans = tmp;
			} else {
				ans -= tmp;
			}
		}
		System.out.println(ans);
	}
}
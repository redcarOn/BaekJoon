
// No.14719(빗물) - 54
// 구현 + 시뮬레이션
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_14719 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] block = new int[W];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < W; i++) {
			block[i] = Integer.parseInt(st.nextToken());
		}

		int ans = 0;

		for (int i = 1; i < W - 1; i++) {
			int leftMax = 0;
			int rightMax = 0;

			for (int j = 0; j < i; j++) {
				leftMax = Math.max(leftMax, block[j]);
			}

			for (int j = i + 1; j < W; j++) {
				rightMax = Math.max(rightMax, block[j]);
			}

			int minHeight = Math.min(leftMax, rightMax);

			if (minHeight > block[i]) {
				ans += minHeight - block[i];
			}
		}

		System.out.println(ans);
	}
}
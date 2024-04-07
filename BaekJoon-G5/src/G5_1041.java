
// No.1041(주사위) - 50
// 그리디 알고리즘
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_1041 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		long N = Integer.parseInt(br.readLine());
		long[] dice = new long[6];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 6; i++) {
			dice[i] = Long.parseLong(st.nextToken());
		}

		if (N == 1) {
			Arrays.sort(dice);
			int sum = 0;
			for (int i = 0; i < 5; i++) {
				sum += dice[i];
			}
			System.out.println(sum);
		} else {
			long min1 = Integer.MAX_VALUE;
			long min2 = Integer.MAX_VALUE;
			long min3 = 0;

			for (int i = 0; i < 6; i++) {
				min1 = Math.min(min1, dice[i]);
			}

			for (int i = 0; i < 5; i++) {
				for (int j = i + 1; j < 6; j++) {
					if (i + j != 5) {
						min2 = Math.min(min2, dice[i] + dice[j]);
					}
				}
			}

			for (int i = 0; i < 3; i++) {
				min3 += Math.min(dice[i], dice[5 - i]);
			}

			long ans = min1 * (4 * (N - 1) * (N - 2) + (N - 2) * (N - 2)) + min2 * (4 * (N - 1) + 4 * (N - 2))
					+ min3 * 4;
			System.out.println(ans);
		}
	}
}
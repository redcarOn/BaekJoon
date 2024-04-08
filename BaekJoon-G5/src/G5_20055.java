
// No.20055(컨베이어 벨트) - 52
// 구현 + 시뮬레이션
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_20055 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] belt = new int[N * 2];
		boolean[] robot = new boolean[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < belt.length; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}

		int round = 1;
		int cnt = 0;

		while (true) {
			int tmp = belt[belt.length- 1];
			for (int i = belt.length - 1; i > 0; i--) {
				belt[i] = belt[i - 1];
			}
			belt[0] = tmp;

			for (int i = robot.length - 1; i > 0; i--) {
				robot[i] = robot[i - 1];
			}
			robot[0] = robot[N - 1] = false;

			for (int i = N - 2; i >= 0; i--) {
				if (robot[i] && !robot[i + 1] && belt[i + 1] > 0) {
					robot[i] = false;
					robot[i + 1] = true;
					belt[i + 1]--;

					if (belt[i + 1] == 0) {
						cnt++;
					}
				}
			}
			robot[N - 1] = false;

			if (!robot[0] && belt[0] > 0) {
				robot[0] = true;
				belt[0]--;

				if (belt[0] == 0) {
					cnt++;
				}
			}

			if (cnt >= K) {
				break;
			}
			round++;
		}

		System.out.println(round);
		br.close();
	}
}
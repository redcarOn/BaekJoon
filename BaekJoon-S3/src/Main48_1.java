
//No.2503 - 정리
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class BallCount {
	int num;
	int strike;
	int ball;

	public BallCount(int num, int strike, int ball) {
		this.num = num;
		this.strike = strike;
		this.ball = ball;
	}
}

public class Main48_1 {
	public static ArrayList<BallCount> list = new ArrayList<>();
	public static int N, count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());

			list.add(new BallCount(num, strike, ball));
		}

		for (int i = 123; i < 988; i++) {
			int a = i / 100;
			int b = (i / 10) % 10;
			int c = i % 10;

			if (a == 0 || b == 0 || c == 0 || a == b || a == c || b == c) {
				continue;
			}
			if (find(a, b, c)) {
				count++;
			}
		}
		System.out.println(count);
	}

	public static boolean find(int a, int b, int c) {

		for (int i = 0; i < list.size(); i++) {
			BallCount tmp = list.get(i);

			int tmpa = tmp.num / 100;
			int tmpb = (tmp.num / 10) % 10;
			int tmpc = tmp.num % 10;

			int strike = tmp.strike;
			int ball = tmp.ball;

			int st = 0;
			int ba = 0;

			if (tmpa == a)
				st++;
			if (tmpb == b)
				st++;
			if (tmpc == c)
				st++;

			if (tmpb == a || tmpc == a)
				ba++;
			if (tmpa == b || tmpc == b)
				ba++;
			if (tmpa == c || tmpb == c)
				ba++;

			if (strike != st || ball != ba) {
				return false;
			}
		}
		return true;
	}
}
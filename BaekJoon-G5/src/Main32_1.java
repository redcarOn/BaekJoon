
//No.14891(톱니바퀴) - 구현(연결리스트)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main32_1 {
	private static ArrayList<LinkedList<Integer>> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		list = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			list.add(new LinkedList<>());
		}

		for (int i = 1; i <= 4; i++) {
			String s = br.readLine();

			for (int j = 0; j < s.length(); j++) {
				list.get(i).add(s.charAt(j) - '0');
			}
		}

		int K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());

			func(num, dir);
		}

		int ans = 0;

		for (int i = 1; i <= 4; i++) {
			if (list.get(i).get(0) == 1) {
				ans += Math.pow(2, i - 1);
			}
		}

		System.out.println(ans);
	}

	public static void func(int num, int dir) {
		leftSide(num - 1, -dir);
		rightSide(num + 1, -dir);
		rotate(num, dir);
	}

	public static void leftSide(int num, int dir) {
		if (num < 1) {
			return;
		}
		if (list.get(num).get(2) == list.get(num + 1).get(6)) {
			return;
		}
		leftSide(num - 1, -dir);
		rotate(num, dir);
	}

	public static void rightSide(int num, int dir) {
		if (num > 4) {
			return;
		}
		if (list.get(num).get(6) == list.get(num - 1).get(2)) {
			return;
		}
		rightSide(num + 1, -dir);
		rotate(num, dir);
	}

	public static void rotate(int num, int dir) {
		if (dir == 1) {
			list.get(num).add(0, list.get(num).remove(7));
		} else {
			list.get(num).add(list.get(num).remove(0));
		}
	}
}

//No.2841(외계인의 기타 연주) - 스택(리스트)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main64 {
	public static int N, P;
	public static ArrayList<Stack<Integer>> list;
	public static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		list = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= 6; i++) {
			list.add(new Stack<>());
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());

			guitar(m, f);
		}
		System.out.println(cnt);
	}

	public static void guitar(int line, int fret) {
		while (true) {
			if (list.get(line).isEmpty()) {
				list.get(line).push(fret);
				cnt++;
				break;
			} else {
				if (list.get(line).peek() < fret) {
					list.get(line).push(fret);
					cnt++;
					break;
				} else if (list.get(line).peek() == fret) {
					break;
				} else {
					list.get(line).pop();
					cnt++;
				}
			}
		}
	}
}
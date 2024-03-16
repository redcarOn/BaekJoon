
//No.2841(외계인의 기타 연주) - 스택(배열)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main64_1 {
	public static int N, P;
	public static Stack<Integer>[] stack;
	public static int cnt = 0;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		stack = new Stack[7];

		for (int i = 1; i <= 6; i++) {
			stack[i] = new Stack<Integer>();
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
			if (stack[line].isEmpty()) {
				stack[line].push(fret);
				cnt++;
				break;
			} else {
				if (stack[line].peek() < fret) {
					stack[line].push(fret);
					cnt++;
					break;
				} else if (stack[line].peek() == fret) {
					break;
				} else {
					stack[line].pop();
					cnt++;
				}
			}
		}
	}
}
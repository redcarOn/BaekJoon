
//No.1038(감소하는 수) - 백트래킹 + 브루트포스
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main38 {
	public static List<Long> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();

		if (N <= 10) {
			System.out.println(N);

		} else {
			for (int i = 0; i < 10; i++) {
				func(i, 1);
			}

			if (N >= list.size()) {
				System.out.println(-1);
			} else {
				Collections.sort(list);
				System.out.println(list.get(N));
			}
		}
	}

	public static void func(long num, int idx) {
		if (idx > 10) {
			return;
		}

		list.add(num);
		for (int i = 0; i < num % 10; i++) {
			func((num * 10) + i, idx + 1);
		}
	}
}
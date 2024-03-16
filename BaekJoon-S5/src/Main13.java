
//No.1436
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main13 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N > 1) {
			com(N);
		} else {
			System.out.println(666);
		}
	}

	private static void com(int N) {
		int count = 1;
		int prev = 0;
		int back = 0;

		while (true) {
			if (((prev % 10000) / 10) == 666 && prev % 10 != 6) {
				back = 0;
				for (int i = 0; i < 1000; i++) {
					if (count == N) {
						System.out.println(prev * 1000 + back);
						return;
					}
					back++;
					count++;
				}
				prev++;
			} else if (prev % 1000 == 666) {
				back = 0;
				for (int i = 0; i < 1000; i++) {
					if (count == N) {
						System.out.println(prev * 1000 + back);
						return;
					}
					back++;
					count++;
				}
				prev++;
			} else if (prev % 100 == 66) {
				back = 600;
				for (int i = 0; i < 100; i++) {
					if (count == N) {
						System.out.println(prev * 1000 + back);
						return;
					}
					back++;
					count++;
				}
				prev++;
			} else if (prev % 10 == 6) {
				back = 660;
				for (int i = 0; i < 10; i++) {
					if (count == N) {
						System.out.println(prev * 1000 + back);
						return;

					}
					back++;
					count++;
				}
				prev++;
			} else {
				back = 666;
				if (count == N) {
					System.out.println(prev * 1000 + back);
					return;
				}
				count++;
				prev++;
			}
		}
	}
}
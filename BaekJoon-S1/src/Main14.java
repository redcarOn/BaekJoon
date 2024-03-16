
//No.6588(골드바흐의 추축) - 소수 판정
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main14 {
	public static boolean[] arr = new boolean[1000001];
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		prime();

		int idx = 0;
		int input;

		while (idx < 100000) {
			input = Integer.parseInt(br.readLine());

			if (input == 0) {
				break;
			}

			func(input);
			idx++;
		}

		System.out.println(sb);
	}

	public static void func(int n) {
		int first = 2;
		int second = n - 2;

		while (true) {
			if (first > n / 2) {
				sb.append("Goldbach's conjecture is wrong.").append('\n');
				break;
			}

			if (!arr[first] && !arr[second]) {
				sb.append(n + " = " + first + " + " + second).append('\n');
				break;
			}

			first++;
			second--;
		}
	}

	public static void prime() {
		arr[0] = arr[1] = true;

		for (int i = 2; i <= Math.sqrt(arr.length); i++) {
			if (arr[i]) {
				continue;	
			}
			for (int j = i * i; j < arr.length; j += i) {
				arr[j] = true;
			}
		}
	}
}
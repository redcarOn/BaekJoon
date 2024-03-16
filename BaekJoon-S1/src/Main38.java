
//No.1747(소수&팰린드롬) - 브루트포스(소수판정)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main38 {
	public static boolean[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		arr = new boolean[1003002];
		find();

		for (int i = N; i < arr.length; i++) {
			if (!arr[i]) {
				if (func(i)) {
					System.out.println(i);
					return;
				}
			}
		}
	}

	public static void find() {
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

	public static boolean func(int N) {
		char[] str = Integer.toString(N).toCharArray();
		int size = str.length;

		if (size == 1) {
			return true;
		}

		int start = 0;
		int end = size - 1;

		while (start < end) {
			if (str[start] != str[end]) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
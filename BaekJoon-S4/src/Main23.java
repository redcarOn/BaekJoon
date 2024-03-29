
//No.10610
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main23 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String N = br.readLine();
		char[] arr = N.toCharArray();
		Arrays.sort(arr);
		int sum = 0;

		for (int i = arr.length - 1; i >= 0; i--) {
			int num = arr[i] - '0';
			sum += num;
			sb.append(num);
		}

		if (arr[0] != '0' || (sum % 3) != 0) {
			System.out.println(-1);
			return;
		}
		System.out.println(sb);
	}
}

//No.4375★
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main35 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = null;

		while ((input = br.readLine()) != null && !input.isEmpty()) {
			int n = Integer.parseInt(input);
			int sum = 0;

			for (int i = 1; i <= n; i++) {
				sum = sum * 10 + 1;
				sum %= n;
				if (sum == 0) {
					sb.append(i).append('\n');
					break;
				}
			}
		}
		System.out.println(sb);
	}
}